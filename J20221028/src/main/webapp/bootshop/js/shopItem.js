// shopItem.js

fetch('../ShopItemListServlet')
    .then(result => result.json())
    .then(itemListShow)
    .catch(err => console.log(err));

function itemListShow(result) {
    // console.log(result);
    result.forEach(item => {
        makeItemDiv(item);
    });
}


function makeItemDiv(item = {}) {

    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true);
    good.querySelector('h5').textContent = item.itemName
    good.querySelector('img.card-img-top').src = '../images/' + item.image
    good.querySelector('span.text-muted').textContent = item.originPrice;
    good.querySelector('span.text-muted').nextSibling.textContent = '\t' + item.salePrice;

    // review
    let review = item.likeIt; // 4.5
    let a = Math.floor(review); // 온쪽
    let b = review - a; // 0, .5

    for (let i = 0; i < a; i++) {
        let div = document.createElement('div');
        div.className = 'bi-star-fill';
        good.querySelector('div.d-flex').append(div);
    }
    if (b) {
        let div = document.createElement('div');
        div.className = 'bi-star-half';
        good.querySelector('div.d-flex').append(div);
    }

    // 목록
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);

    // add to Cart 누를 시 Cart 1 추가
    good.querySelector("a.btn").addEventListener('click',function(){
        console.log('확인')
        // let num = Number(document.querySelector('span.badge').textContent);
        document.querySelector('span.badge').textContent ++;
    })

    // console.log(good);
}