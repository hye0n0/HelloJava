// dom2.js

document.addEventListener('DOMContentLoaded', domloadedFunc);

function domloadedFunc(){
    let data = `[{"id":1,"first_name":"Orella","last_name":"Haseley","email":"ohaseley0@multiply.com","gender":"Female","salary":4853},
                {"id":2,"first_name":"Sindee","last_name":"Meadley","email":"smeadley1@cnbc.com","gender":"Female","salary":8494},
                {"id":3,"first_name":"Gennie","last_name":"Byatt","email":"gbyatt2@macromedia.com","gender":"Female","salary":6522},
                {"id":4,"first_name":"Cale","last_name":"Gehricke","email":"cgehricke3@discuz.net","gender":"Male","salary":2587}
                ]`;
    let result = JSON.parse(data); // json => object
/*    console.log(result);

    console.log(result[1].email);
    for (let i=0; i<result.length; i++){
        console.log(`firstName: ${result[i].first_name}, lastName: ${result[i]['last_name']}`);
    }

    // 확장for
    for(let obj of result){
        console.log(`id: ${obj.id}, email: ${obj['email']}`);
    }
    console.clear();
    // 배열일 경우에는 Array.forEach()
    result.forEach(function(value, index){
        // if (value.salary > 5000)
        if (index < 2)
            console.log(value, index);
    });*/
    
    // 확장 for
        // table
    let table = document.createElement('table');
    let show = document.getElementById('show');
    show.appendChild(table);
        // thead
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
    for (let title of titles){
        let idTag = document.createElement('th');
        let idTxt = document.createTextNode(title); // <th>아이디</th>
        idTag.appendChild(idTxt);
        tr.appendChild(idTag);
    }
    let idTag = document.createElement('th');
    let checkbox = document.createElement('input');
    // 맨위체크박스 누르면 전체 선택
    checkbox.addEventListener('change', function(){
		document.querySelectorAll('#show input[type="checkbox"]').forEach(function(check){
			check.checked = checkbox.checked;
		});
	})
    checkbox.setAttribute('type','checkbox');
	checkbox.setAttribute('name','checkbox');
	idTag.appendChild(checkbox);
	tr.appendChild(idTag);
	thead.appendChild(tr);
    table.appendChild(thead);
        //tbody
    let tbody = document.createElement('tbody');
    table.appendChild(tbody);
    let fields = ['id', 'first_name', 'email', 'gender', 'salary'];
    for (let obj of result){
	
        let tr = makeTr(obj);
        tbody.appendChild(tr);
    } // end of for (let obj of result)	
    
    function makeTr(row){
		//데이터 건수만큼 반복
        let tr = document.createElement('tr');
        tr.addEventListener('click', showDetailfunc);
        tr.addEventListener('mouseout',function(){
            this.style.backgroundColor = null;
        });
        for (let field of fields){
            //항목만큼 반복
            let td = document.createElement('td');
            let txt = document.createTextNode(row[field]);
            td.appendChild(txt);
            tr.appendChild(td);
        }
        // 삭제버튼 <td><button>삭제</button></td>
        let td = document.createElement('td');
        let btn = document.createElement('button');
        btn.addEventListener('click', function(){
            console.log(this);
            this.parentElement.parentElement.remove();
        });
        let txt = document.createTextNode('삭제');
        btn.appendChild(txt);
        td.appendChild(btn);
        tr.appendChild(td);
        td = document.createElement('td');
        let check = document.createElement('input');
        check.addEventListener('change', function(){
			console.log(this.checked);

		});
        check.setAttribute('type','checkbox');
		check.setAttribute('name','check');
		td.appendChild(check);
		tr.appendChild(td);
        return tr;
	} // end of makeTr()
	
	///////////////////////////// 이벤트 /////////////////////////////////////////
	
	// 추가버튼에 이벤트 등록
	document.querySelector('button[type="button"]').addEventListener('click', addfunc);
	// 수정버튼에 이벤트등록
	document.querySelectorAll('button[type="button"]')[1].addEventListener('click', updatefunc);
	// 선택삭제 이벤트등록
	document.querySelectorAll('button[type="button"]')[2].addEventListener('click', deletefunc);
	 
	// 추가버튼
	function addfunc(){
		let id = document.getElementById('id').value;
		let fn = document.getElementById('fname').value;
		let em = document.getElementById('email').value;
		let sa = document.getElementById('salary').value;
		let gn = document.getElementById('gender').value;
		let newRow = {
			id: id,
			first_name: fn,
			email: em,
			salary: sa,
			gender: gn
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow));
	}
	
	// 수정버튼
	function updatefunc(){
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		
		for(let i=0;i<trs.length;i++){
			if(trs[i].children[0].textContent == document.getElementById('id').value){
				trs[i].children[1].textContent = document.getElementById('fname').value;
				trs[i].children[2].textContent = document.getElementById('email').value;
				trs[i].children[3].textContent = document.getElementById('gender').value;
				trs[i].children[4].textContent = document.getElementById('salary').value;
			}
		}
	}
	
	// 선택삭제
	function deletefunc(){
		let dchs = document.querySelectorAll('input[type="checkbox"]:checked');
		for(let dch of dchs){
			dch.parentElement.parentElement.remove();
		}
		
	}
	
	// 선택 데이터를 input에 출력
	function showDetailfunc(){
		this.style.backgroundColor = 'yellow';

        document.getElementById('id').value = this.children[0].textContent;
        document.getElementById('fname').value = this.children[1].textContent;
        document.getElementById('email').value = this.children[2].textContent;
        document.getElementById('gender').value = this.children[3].textContent;
        document.getElementById('salary').value = this.children[4].textContent;
	}
} // end of domloadedFunc()