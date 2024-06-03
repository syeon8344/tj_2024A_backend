/*
    - 회원가입 페이지
        1. 회원정보 : 1. 회원번호 2. 아이디 3. 비밀번호, 4. 이름. 5. 연락처
        2. 입력사항 : 아이디, 비밀번호, 비밀번호 확인, 이름, 연락처
        3. 유효성 검사: // 조금 나중에?
            1. 아이디 비밀번호 >= 5글자만
            2. 이름은 3글자 이상
            3. 연락처는 - 제외 8자리 숫자부터
            4. 비밀번호와 비밀번호확인 일치시 가능
            5. 아이디 연락처는 중복제외
        *회원번호는 자동 부여
        *회원목록은 localsSorage에 저장
*/

let memberList = JSON.parse(localStorage.getItem("mList"))
if (memberList == null) {memberList = []; localStorage.setItem("mList", JSON.stringify(memberList))}
function signup(){ // HTML 가져오기 > 유효성검사 > 데이터 가공 > 저장 > 결과
    let memberList = JSON.parse(localStorage.getItem("mList"))
    let id=document.querySelector("#id").value;
    let pw=document.querySelector("#pw").value;
    let pwconfirm=document.querySelector("#pwconfirm").value;
    let name=document.querySelector("#name").value;
    let phone=document.querySelector("#phone").value;

    if (id.length <5) { alert('아이디는 5글자 이상'); return;} // 유효성검사
    if (pw.length <5) { alert("비밀번호는 5글자 이상"); return;}
    if (name.length < 3) {alert('이름은 3글자 이상'); return;}
    if (phone.length < 8 || isNaN(phone)) { alert('연락처는 -제외 8글자 이상'); return;}
    if (pw != pwconfirm) {alert('두 비밀번호가 같지 않음'); return;}

    for (let i = 0; i < memberList.length; i++){ // 또는 for (let member of memberList) {if (member.id == id) ...}
        if (memberList[i].id == id) {alert('아이디가 중복됨'); return;}
        if (memberList[i].phone == phone) {alert('연락처가 중복됨'); return;}
    }

    let no = memberList.length == 0 ? 1 : memberList[member.length-1].no + 1
    let member = {no : no, id : id, pw : String(pw), name : name, phone : phone};
    memberList.push(member);
    localStorage.setItem("mList", JSON.stringify(memberList))
    alert('회원가입성공'); location.href="login.html" // 페이지 이동 script
}