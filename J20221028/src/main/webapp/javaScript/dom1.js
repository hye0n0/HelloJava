// dom1.js
// DOM 활용해서 페이지 생성

document.addEventListener('DOMContentLoaded', function(){
	let show = document.getElementById('show');
	let form = document.createElement('form');
	// id
	let txt = document.createTextNode('ID: ');
	let input = document.createElement('input');
	input.setAttribute('type','text');
	input.setAttribute('id','id');
	let br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);	
	// name
	txt = document.createTextNode('Name');
	input = document.createElement('input');
	input.setAttribute('type','text');
	input.setAttribute('name','name');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);	
	// phone
	txt = document.createTextNode('Phone');
	input = document.createElement('input');
	input.setAttribute('type','text');
	input.setAttribute('phone','phone');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
	// 전송
	input = document.createElement('input');
	input.setAttribute('type','submit');
	input.setAttribute('value','전송');
	form.appendChild(input);
	show.appendChild(form);
})

