fetch('./MemberListServlet', {
    method: 'get'
    })
    .then(result => result.json())
    .then(listShow)
    .catch(error => console.error(error));

function listShow(data = []) {
    data.forEach(member => {
        if(member.resposibility == 'admin'){
            console.log(member);
        }
    })

    // 권한 user인 사람들만 userGroup
    let userGroup = [];
    // forEach를 사용하면..
    data.forEach(member => {
        if(member.resposibility == 'user'){
            userGroup.push(member);
        }
    })

    // filter를 사용하면..
    // userGroup = data.filter(mem => mem.resposibility = 'user').map(member => {
    //     let newMem = {};
    //     newMem.u_id = member.id;
    //     newMem.u_name = member.name;
    //     newMem.u_email = member.email;
    //     return newMem;
    // });

    userGroup.forEach(obj => console.log(obj));
}