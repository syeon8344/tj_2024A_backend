// 전역
let 변수1 = '대한민국';

if ( true) {    // 지역 { }

    let 변수2 = '인천';
    console.log(변수1); // O
    console.log(변수2); // O
    //console.log(변수3); // X

    for (let i=0; i < 1; i++){  // 지역 2 { }
        let 변수3 = '부평'
        console.log(변수1); // O
        console.log(변수2); // O
        console.log(변수3); // O


    }
}

function 경기도 ( ){
    let 서장훈 = '수원시'
}


console.log(변수1); // O

//console.log(변수2); // X

//console.log(변수3); // X

// 전역변수와 지역변수의 활용 예

let 배열 = [];   // 전역변수

function 등록() {
    // let 배열 = []; -> 함수가 끝나면 없어짐
    //let 입력 = prompt('성명')
    
    let 입력 = document.querySelector('#성명').value; // 지역변수
    
    배열.push(입력)
    document.querySelector('#출력박스').innerHTML = 배열;



}
/*
// 함수 사용하는 이유 
    1. 반복되는 코드를 한번에 정리, 필요에 따라 호출하여 반복을 줄인다
    2. 긴 프로그램을 기능별로 나눠 여러 함수로 모듈화하여 전체 코드 가독성을 높인다
    3. 기능별(함수별)로 수정이 편하고 유지보수가 쉽다
    4. 매개변수/인수에 따른 서로 다른 결과물
    5. {}지역 변수를 사용하기 때문에 메모리 효율성이 좋다 (함수 실행때만 중괄호에 메모리 할당)

    */