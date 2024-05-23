/*

    1. 세미콜론 ;
        - 컴퓨터에게 문장 마침 알림 역할
        - JS: 한줄에 코드문장 1개일 때 생략가능
        - 한줄에 코드문장 2개 이상일 때는 문장마다 ; 마침 필요

    2. 데이터 타입
        typeof data : data 타입/형식을 출력
        - HTML 언어는 문자열 (...text...)

    3. 문자열 처리
        1. " ", ' ', ` `
            - 백틱 문자열 템플릿
            - 문자열 ${JS코드} 문자열
        2. 변수와 연산자는 문자처리 안됨
    
    4. 문자열과 배열은 같다
    
*/

// 1.
console.log('aaa');
// console.log('aaa') console.log('bbb') -> 오류
console.log('aaa'); console.log('bbb');


// 2.
console.log(typeof '사과') // string
console.log(typeof 10)     // number
console.log(typeof true)   // boolean
console.log(typeof [1, 2]) // object : 객체 (array 포함)


// 3.
console.log('10') // 따옴표 섞을 수 없음
console.log(10)
console.log('사과"10"')
console.log(`사과10`)

// 4.
let num = 40;
console.log('사과' + '배');      // 문자열 + 문자열 : 연결연산자
console.log('사과' + 20);        // 문자열 + 숫자 : 연결연산자 -> 문자열
console.log('사과' + num);       // 문자열 + 변수 : 연결연산자 -> 문자열
console.log(`${'사과'}${'배'}`); // 템플릿 엔진  ${JS코드}
console.log(`${num}`)

// 4-1.
let fruit1 = '사과'
let fruit2 = '배'

let fruitHTMLbt = `<ol><li>사과</li><li>배</li></ol>`;
document.write(fruitHTMLbt);

let fruitHTMLstr = '<ol><li>사과</li><li>배</li></ol>';
document.write(fruitHTMLstr);

let fruitHTMLbtvar = `<ol><li>${fruit1}</li><li>${fruit2}</li></ol>`;
document.write(fruitHTMLbtvar);

let fruitHTMLstrvar = '<ol><li>' + fruit1 + '</li><li>' + fruit2 + '</li></ol>';
document.write(fruitHTMLstrvar);

// 5.
let 차량번호= '15마5555';
console.log(차량번호[1]);          // 5
console.log(차량번호.length);      // 7
let split차량번호 = 차량번호.split('마');   // 특정 문자 기준으로 잘라서 배열로 출력
console.log(split차량번호);                // ['15', '5555']

// 예시1 : 사원 2명의 이름, 나이를 입력받아 HTML(table) 형식으로 출력, 템플릿 엔진으로

let name1 = prompt('첫번째 사원 이름: ');
let age1 = prompt('첫번째 사원 나이: ');
let name2 = prompt('두번째 사원 이름: ');
let age2 = prompt('두번째 사원 나이: ');

let table = `<table>
                <tr>
                    <th>이름</th><th>나이</th>
                </tr>
                <tr>
                    <td>${name1}</td><td>${age1}</td>
                </tr>
                <tr>
                    <td>${name2}</td><td>${age2}</td>
                </tr>
            </table>`;

document.write(table);