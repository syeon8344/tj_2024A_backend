// 1. 로그인 상태에 따라 헤더메뉴를 구성하기
loginState();
function loginState(){ // 실행조건 1.페이지로드
    let loginNo = sessionStorage.getItem("loginNo")
    if (loginNo == null) { loginNo = 0;} // 로그인번호가 없으면

    let html = '';
    let nav = document.querySelector(".navbar-nav")
    if (loginNo != 0) { // 로그인 O , login.js에서 넘어오는 정보
        html = `<li class="nav-item"><a class="nav-link" href="info.html">내정보</a></li>
                <li class="nav-item"><a class="nav-link" href="#" onclick="logout()">로그아웃</a></li>`;
    } else { // 로그인 X
        html = `<li class="nav-item"><a class="nav-link" href="signup.html">회원가입</a></li>
                <li class="nav-item"><a class="nav-link" href="login.html">로그인</a></li>`
    }
    nav.innerHTML += html;
}

function logout(){ //로그아웃
    sessionStorage.removeItem("loginNo");
    alert("로그아웃되었습니다.")
    location.href="index.html"
}

//http://192.168.30.186:5500/day19/index.html