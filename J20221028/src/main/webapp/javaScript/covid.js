// covid.js

window.onload = function () {
    // request url
    let url =
        "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=Wc9uruHt6uuL10Q5X5t0ZtLPTEozovfGTJZMPeVxt1jqmStaKp6WJDFsofM60bgoo2W9w6G%2Fqk7S%2FOT4FJD9vA%3D%3D";
    fetch(url)
        .then(result => result.json()) // json = object
        .then(showList)
        .catch(err => console.log(err));

    document.querySelector('#findBtn').addEventListener('click', findCenterList);
}
let titles = {
    id: '센터아이디',
    centerName: '센터명',
    phoneNumber: '연락처',
    lat: '위도',
    lng: '경도'
}
let data;

function showList(result) {
    // 타이틀 생성부분
    makeHead();

    // body 영역 생성. 데이터 초기화
    console.log(result);
    data = result.data;

    // option 태그 생성
    makeOption(data);

    let seletcedCity = data.filter(center => center.sido == '서울특별시');
    makeList(seletcedCity);

}

function makeOption(ary = []) {
    // select 태그 생성
    let sidoAry = []; // ['서울특별시','대전광역시','인천광역시','경기도'...]
    data.forEach(center => {
        // data에 있는 센터정보와 sidoAry에 있는 센터정보를 비교
        // sidoAry에 값이 있으면 no, sidoAry에 값이 없으면 추가
        if (sidoAry.indexOf(center.sido) == -1) {
            sidoAry.push(center.sido)
        }
    })
    let cityList = document.getElementById('city');
    for (let sido of sidoAry) {
        let op = document.createElement('option');
        op.setAttribute('value', sido)
        let txt = document.createTextNode(sido)
        op.appendChild(txt);
        cityList.append(op);
    }
}

function makeList(ary = []) {
    // 화면에 tr이 있으면 tr삭제
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove());
    let list = document.getElementById('list');
    ary.forEach((center,idx) => {
        list.append(makeTr(center,idx));
    })
}

function findCenterList() {
    let searchkey = document.getElementById('city').value;
    let searchAry = data.filter(center => center.sido == searchkey);
    makeList(searchAry);
}

function makeTr(row = {},idx=0) {
    let tr = document.createElement('tr');
    tr.setAttribute('lat', row.lat);
    tr.setAttribute('lng', row.lng);
    tr.setAttribute('facilityName', row.facilityName);
    tr.addEventListener('click',openInfoWindow);
    // td 생성
    let td = document.createElement('td');
    td.textContent = idx+1;
    tr.prepend(td); // append(): 마지막위치에 추가, prepend(): 처음위치에 추가
    for (let field in titles) {
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]);
        td.appendChild(txt);
        tr.appendChild(td);
    }
    return tr
}

function openInfoWindow(e) {
    console.log(e.target.parentElement); // tr lng, lat
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let fn = e.target.parentElement.getAttribute('facilityName');
    window.location.href = 'infoWindow.html?x=' + lng + '&y=' + lat + '&fn=' + fn;
}

function makeHead() {
    // 타이틀
    let tr = document.createElement('tr');
    let th = document.createElement('th');
    th.textContent = '순번';
    tr.appendChild(th);
    for (let title in titles) {
        let th = document.createElement('th');
        let txt = document.createTextNode(titles[title]);
        th.appendChild(txt);
        tr.appendChild(th);
    }
    document.getElementById('title').append(tr);
}