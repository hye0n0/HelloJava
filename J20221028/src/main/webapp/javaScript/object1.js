// object1.js

function Student(stdNo, stdName, mathScore) {
    this.stdNo = stdNo;
    this.stdName = stdName;
    this.mathScore = mathScore;
}

let std1 = new Student('1111', '김민수', '80');
let std2 = new Student('2222', '이수만', '85');
let std3 = new Student('3333', '홍수현', '90');

const students = [std1, std2, std3];

// <ul><li>학생1</li><li>학생1</li><li>학생1</li></ul>
// <ul></ul>
let ulTag = document.createElement('ul');
for(let i=0;i<students.length;i++){
    let liTag = document.createElement('li');
    let txt = document.createTextNode(`학번: ${students[i].stdNo} 이름: ${students[i].stdName} 점수: ${students[i].mathScore}`);
    ulTag.appendChild(liTag);
    liTag.appendChild(txt);
}


document.getElementById('show').appendChild(ulTag);