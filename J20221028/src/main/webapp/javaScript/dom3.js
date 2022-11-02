/**
 *  dom3.js
 */
 
 document.addEventListener('DOMContentLoaded', function(){
	
/*	document.querySelector('button').addEventListener('click',function(){
		// 아이디 조회해서 화면에서 삭제
		
	})*/
		
	let tableObject = {
		id: 'hong',
		titles: ["아이디", "이름", "이메일", "삭제"],
		data: [{id: 'user1', name: '홍길동', email: 'hong@email'},
				{id: 'user2', name: '김민서', email: 'kim@email'},
				{id: 'user3', name: '박항서', email: 'park@email'}],
		makeTable: function(){
			let table = document.createElement('table');
			let thead = this.makeHead();
			let tbody = this.makeBody();
			table.append(thead,tbody);
			return table;
		},
		makeHead: function(){
			let thead = document.createElement('thead');
			let tr = document.createElement('tr');
			this.titles.forEach(function(title){
				let th = document.createElement('th');
				let txt = document.createTextNode(title);
				th.append(txt);
				tr.append(th);
			})
			thead.append(tr);
			return thead;
		},
		makeBody: function(){
			let tbody = document.createElement('tbody');
			this.data.forEach(val => {
				let tr = document.createElement('tr');
				for (let field in val){
					console.log(val[field]);
					let td = document.createElement('td');
					let txt = document.createTextNode(val[field]);
					td.append(txt);
					tr.append(td);
				}
				let td = document.createElement('td');
				let btn = document.createElement('button');
				// 삭제버튼 클릭하면 한건삭제
				btn.addEventListener('click', function(){
					this.parentElement.parentElement.remove();
				})
				let txt = document.createTextNode('삭제');
				btn.append(txt);
				td.append(btn);
				tr.append(td);
				
				tbody.append(tr);
			});
			return tbody;
		},
		addData: function(newVal){
			let tr = document.createElement('tr');
			for (let field in newVal){
				console.log(newVal[field]);
				let td = document.createElement('td');
				let txt = document.createTextNode(newVal[field]);
				td.append(txt);
				tr.append(td);
			}
			let td = document.createElement('td');
			let btn = document.createElement('button');
			// 삭제버튼 클릭하면 한건삭제
			btn.addEventListener('click', function(){
				this.parentElement.parentElement.remove();
			})
			let txt = document.createTextNode('삭제');
			btn.append(txt);
			td.append(btn);
			tr.append(td);
			
			document.querySelector('table>tbody').appendChild(tr);
		},
		init: function() {
			let id = 'kim';
			console.log('init call ' + this.id);
			document.getElementsByTagName('body')[0].append(this.makeTable());
		}
	}
	
	
	
	// 데이터 추가 
	tableObject.addData({id: 'user4', name: '황성홍', email: 'hwang@email'});
	tableObject.init();
	
	/////////////////////////// 스타일 ///////////////////////////////////
//	document.querySelector(#show>table).style.backgroundColor = 'gray';
});// end of domloadedFunc()