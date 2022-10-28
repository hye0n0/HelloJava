/**
 * object2.js
 */
 
 document.addEventListener('DOMContentLoaded', function(){
//	document.getElementById('show').innerHTML = '<p>Hello, World</p>';
	let data = `[{"id":1,"first_name":"Orella","last_name":"Haseley","email":"ohaseley0@multiply.com","gender":"Female","salary":4853},
{"id":2,"first_name":"Sindee","last_name":"Meadley","email":"smeadley1@cnbc.com","gender":"Female","salary":8494},
{"id":3,"first_name":"Gennie","last_name":"Byatt","email":"gbyatt2@macromedia.com","gender":"Female","salary":6522},
{"id":4,"first_name":"Cale","last_name":"Gehricke","email":"cgehricke3@discuz.net","gender":"Male","salary":2587},
{"id":5,"first_name":"Bobette","last_name":"Greggersen","email":"bgreggersen4@de.vu","gender":"Female","salary":4224},
{"id":6,"first_name":"Samaria","last_name":"Spybey","email":"sspybey5@statcounter.com","gender":"Female","salary":6989},
{"id":7,"first_name":"Constantina","last_name":"Burgwin","email":"cburgwin6@blog.com","gender":"Female","salary":8743},
{"id":8,"first_name":"Price","last_name":"Daffern","email":"pdaffern7@spiegel.de","gender":"Male","salary":7800},
{"id":9,"first_name":"Leigh","last_name":"Cowmeadow","email":"lcowmeadow8@bluehost.com","gender":"Male","salary":7170},
{"id":10,"first_name":"Meagan","last_name":"Pauley","email":"mpauley9@issuu.com","gender":"Female","salary":6759}]`;

// json 타입 => javascript 오브젝트

let result = JSON.parse(data);
console.log(result);

// for (String str : personList) {}
// <ul><li>obj</li><li>obj</li><li>obj</li></ul>
// <div id="show"></div>
const fields = ['id', 'first_name', 'email', 'salary'];
/*
let ulTag = document.createElement('ul');

for (row of result){
	ulTag.appendChild(makeList(row));
}

document.getElementById('show').appendChild(ulTag);


function makeList(obj){
	let liTag = document.createElement('li');
	let str = '';
	for (field of fields){
		str += `${field}: ${obj[field]}`;
	}
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}
*/
let tabTag = document.createElement('table');
let trTag = document.createElement('tr');
let thTag = document.createElement('th');
for (field of fields){
	let txt = document.createTextNode(field);
	str += thTag.appendChild(txt);
}
trTag.appendChild(str);

for (row of result){
	tabTag.appendChild(makeList(row));
}

document.getElementById('show').appendChild(tabTag);

function makeTr(obj){
	let tdTag = document.createElement('td');
	let str = "";
	

	return trTag;
}

});
 
 