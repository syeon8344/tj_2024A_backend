/*
    document: HTML 전체 요소
        - 선택자 : CSS 동일
        1. 마크업, 2. 클래스명. 3. ID명 4. 자식 : > , 자손은 띄어쓰기


    - 요소 가져오기 함수
        - document.querySelector('선택자') : 요소 1개 객체 반환
        - document.querySelectorAll('선택자') : 요소 여러개 객체 배열로 반환

    - 요소 조작 속성/함수
        - .innerHTML 속성
            - 사용가능: <div>, <table>, <ol> 등 열고 닫는 마크업
            - 사용불가능 요소: <input/> <img/> <br/> 등 
            <호출> document.querySelector('선택자').innerHTML
            <수정> document.querySelector('선택자').innerHTML = HTML 형식 문자열

        - value 속성
            - 사용가능 요소 : <input / > <select> <textarea> 등
            - 사용불가능 요소: <div>, <table> 등
            <호출> document.querySelector('선택자').value
            <수정> document.querySelector('선택자').value = HTML 형식 문자열

        - src 속성
            - 사용가능 요소 : <img /> <audio /> <video /> 등
            <호출> document.querySelector('선택자').src
            <수정> document.querySelector('선택자').src = '새 파일 경로'

        - style 속성
            <전체호출> document.querySelector('선택자').style
            <전체수정> document.querySelector('선택자').style.cssText = '새로운 CSS'
            <일부호출> document.querySelector('선택자').style.css속성명
            <일부수정>document.querySelector('선택자').style.css속성명 = '속성값'

            - CSS 속성명 작성시 카멜표기법 예시
                1. background-color => backgroundColor
                2. margin-left => marginLeft
*/




// 1. DOM객체 확인
console.log(document); // 현재 실행된 HTML 뜻
console.log(document.body);
console.log(document.querySelector("body"));

// 2. document.querySelector('선택자')
    // 마크업선택자 : '마크업명'
console.log(document.querySelector("div"));
console.log(document.querySelectorAll("div"));
    // 클래스선택자 : '.클래스명'
console.log(document.querySelector(".box2"));
    // ID선택자 : '#아이디명'
console.log(document.querySelector("#box3"));
    // 자식, 자손 선택자
console.log(document.querySelector('body > div'))

// 3. 선택된 요소(마크업)을 저장
let box3 = document.querySelector('#box3');
console.log(box3);

// 4. innnerHTML: 문서에 요소 존재 필요
console.log(document.querySelector('.box2').innerHTML)

// 5. value;
let select = document.querySelector('select')
console.log(select.value);
select.value = '수박'

console.log(document.querySelector('input').value)
console.log(select.valu)
document.querySelector("input").value='강호동'

console.log(document.querySelector("textarea").value);
document.querySelector("textarea").value = '긴글텍스트'

//6. src :
document.querySelector('img').src = '../a.jpg'

//7. style
console.log(document.querySelector('#box4').style)
document.querySelector('#box4').style = 'color: white; background-color:blue';
    // 일부분 스타일 : CSS속성명 작성할 때 "-" 사용불가
        // 카멜 표기법 : ex) carSpeed, backgroundColor 등
console.log(document.querySelector('#box4').style.backgroundColor)
document.querySelector("#box4").style.backgroundColor = 'blue';