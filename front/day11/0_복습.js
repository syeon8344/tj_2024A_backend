
    /*
        *DOM 객체
        document.querySelector( ) : 특정 선택자의 html 요소를 js객체로 반환해주는 함수
        '#idname', '.cssName', 'tagName' ...
        *

        DOM객체.innerHTML = 마크업 사이에 넣을 HTML형식의 문자열
            * <마크업> 이곳 </마크업>
            * <div></div>, <p></p> 등 사용가능
            * <input />, <img /> 등은 사용불가
    */

// 1. 복습예제: 특정 html(star1 div)에 "★"을 줄마다 1,2,3,4, 5개 출력하시오
/*let start = '★';
let html = ''
for (let i=1; i<=5; i++) {
    html = html + start.repeat(i) + ' <br/>'
    
}
document.querySelector('#star1').innerHTML= html */

// 2. 평점

/*let rating = Number(prompt('평점: '));

let html = ''
for (let i=0; i < 5; i++) {
    if (rating - i > 0) {html = html + '★'}
        else {html = html + '☆'}
}

document.querySelector('#star2').innerHTML= html*/

// 3. 특정 html (sheet div) 좌석배열 상태에 따라 아래와 같이 출력
    /* 빈 좌석: X, 예약된 좌석: O
       2개씩 3개 출력, 빈 좌석이면 gray, 예약된 좌석이면 red
       ㅁ  ㅁ
       ㅁ  ㅁ
       ㅁ  ㅁ
    */
let sheetArray = ['O','X','O','X','O','X']
let html = ''
for (let i=0; i<sheetArray.length; i++) {
    //if (sheetArray[i] == 'O') {html = html + `<div style='color: red; width: 20px; height: 20px; border: 1px solid black;'> O </div>`}
    //if (sheetArray[i] == 'X') {html = html + `<div style='color: gray; width: 20px; height: 20px; border: 1px solid black;'> X </div>`}
    html += `<div style='color: ${sheetArray[i] == 'O' ? 'red' : 'gray'}; width: 20px; height: 20px; border: 1px solid black;'> ${sheetArray[i] == 'O' ? 'O' : 'X'} </div>`
    if (i!= 0 && i%2 == 1) { html = html + ' <br/> '}
}
console.log (html)
document.querySelector('#sheet').innerHTML= html