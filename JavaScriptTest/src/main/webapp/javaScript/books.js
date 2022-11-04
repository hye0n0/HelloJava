// books.js
document.addEventListener('DOMContentLoaded', function () {
    fetch('./BookListServlet')
        .then(result => result.json())
        .then(makeList)
        .catch(err => console.error(err));

     //선택 삭제
    document.querySelector('button[type="button"]').addEventListener('click', function () {
        let dchs = document.querySelectorAll('#books>table>tbody input[type="checkbox"]:checked');
        for (let dch of dchs) {
            let bookC = dch.parentElement.parentElement.childNodes[1];
            let del = delBook(bookC);
        }
    });
});

// 책리스트 테이블 생성
function makeList(result = []) {
    console.log(result);
    let table = document.createElement('table');
    let fields = ['bookCode', 'bookName', 'author', 'press', 'price']
    //thead
    let thead = document.createElement('thead');
    let checkbox = document.createElement('input');
    // 맨위체크박스 누르면 전체 선택
    checkbox.addEventListener('change', function(){
		document.querySelectorAll('#books input[type="checkbox"]').forEach(function(check){
			check.checked = checkbox.checked;
		});
	})
    checkbox.setAttribute('type','checkbox');
	checkbox.setAttribute('name','checkbox');
    let tr = document.createElement('tr');
    let th = document.createElement('th');
    th.append(checkbox);
    tr.append(th);
    let ths = ['도서코드', '도서명', '저자', '출판사', '가격', '삭제'];
    for (let h of ths) {
        th = document.createElement('th');
        th.textContent = h;
        tr.append(th);
    }
    thead.append(tr);
    // tbody
    let tbody = document.createElement('tbody');
    result.forEach(book => {
        tr = document.createElement('tr');
        let td = document.createElement('td');
        let check = document.createElement('input');
        check.setAttribute('type', 'checkbox');
        td.append(check);
        tr.append(td);
        for (let field of fields) {
            td = document.createElement('td');
            console.log(book.field);
            if(field == 'price'){
                td.textContent = book[field] + '원'; 
            }else{
               td.textContent = book[field]; 
            }
            tr.append(td);
        }
        let btn = document.createElement('button');
        btn.addEventListener('click', function(){
            let bookC = this.parentElement.parentElement.childNodes[1];
            let del = delBook(bookC);
        });
        btn.setAttribute('type', 'button');
        btn.setAttribute('id', 'delBook');
        btn.textContent = '삭제';
        td = document.createElement('td');
        td.append(btn);
        tr.append(td);
        tbody.append(tr);
    });
    table.append(thead, tbody)
    document.getElementById('books').append(table);
}

// DB에 추가 -> 화면에도 추가
function insertBook() {
    let bookCode = document.getElementById('i_bookCode').value;
    let bookName = document.getElementById('i_bookName').value;
    let author = document.getElementById('i_author').value;
    let press = document.getElementById('i_press').value;
    let price = document.getElementById('i_price').value;
    let check = bookCode && bookName && author && press && price;
    if (!check) {
        alert('필수항목입니다')
        return false;
    }
    let data = 'bookCode=' + bookCode + '&bookName=' + bookName + '&author=' + author + '&press=' + press + '&price=' + price;
    console.log(data);
    fetch('./BookAddServlet', {
            method: 'post',
            headers: {
                'Content-type': 'application/x-www-form-urlencoded'
            },
            body: data
        })
        .then(result => result.json())
        .then()
        .catch(err => console.error(err));
}

// 삭제 DB삭제 성공하면 화면에도 삭제
function delBook(bookC) {
    let data = 'bookCode=' + bookC.innerHTML;
    fetch('./BookDelServlet', {
            method: 'post',
            headers: {
                'Content-type': 'application/x-www-form-urlencoded'
            },
            body: data
        })
        .then(result => result.text())
        .then(result => {
            if (result == 'success') {
                bookC.parentElement.remove();
            } else {
                alert('처리중 에러발생')
            }
        })
        .catch(err => console.error(err));
}