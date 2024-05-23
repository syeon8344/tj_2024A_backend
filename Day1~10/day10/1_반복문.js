/*
    JS 제어문 (반복문)
    for
        - 조건을 충족했을 때 특정 범위내 코드를 반복 실행
        - for 형태
            for (초기값; 조건문; 증감식) {반복코드;}
            1. 초기값: 반복 카운터/횟수 체크하는 변수의 처음값
            2. 조건문: 반복실행문이 실행되는 조건 - false가 되면 for 종료
            3. 증감식: 반복변수의 증가 혹은 감소 연산식/패턴
            4. 실행코드: 조건문이 true일 때 실행되는 코드
        - 흐름 순서
            1. 초기값 > 2. 조건문 > 3.실행코드 > 4. 증감식 > 5. 조건문 > 6. 실행코드...
        - 어디서부터 어디까지 몇씩 증가하며 무엇을 실행하는가

        - 배열과 반복문
            - 배열의 인덱스는 순차적인 순서가 존재
            - 배열 순회
                for (let index=0; index < 배열변수.length; index++) {}
            - 향상된 for문
                for (let 반복변수 in 배열변수) {} : 배열변수내 index를 순차적으로 대입 반복
                for (let 반복변수 of 배열변수) {} : 배열변수내 데이터를 순차적으로 대입 반복
            - **스트림 함수들: forEach(), map(), filter()
        
        - for문의 중첩
            for ( ) {
                for ( ) { }
            }
        - 무한루프/무한for문
            for ( ; ; ) { }       // 기본값이 true이므로
            while (true) { }
            - 의미 없는 반복 = 과부하
            - if등 조건문과 같이 써서 특정 조건 하 break ( 종료 )

        - 반복문 키워드
            - break; // 가장 가까운 for문의 { } 탈출/종료
            - continue; // 가장 가까운 for문의 증감식으로 이동 (다시 루프)
 */

// 1.
for (let i=1; i <= 10; i++) {console.log(i);}

// 2.
let sum = 0
for (let i=1; i <= 10; i++) {sum += i; console.log(sum)};

// 3. 1~100 까지 7의 배수만
let sum2 = 0
for (let i=0; i <= 100; i+=7) {sum2 += i;}
console.log(sum2);


// 구구단 2단 표현
for (let i=1; i <= 9; i++) {console.log(` 2 X ${i} = ${2 *+ i}`);}

// 6.
let 과일상자 = ['사과', '포도', '딸기'] 

for (let index=0; index <=2; index++) {console.log(과일상자[index])};
for (let index=0; index <과일상자.length; index++) {console.log(과일상자[index]);}// length 3이므로 -1 또는 < 사용 필요

// 7.
for (let index in 과일상자) {console.log(index);}
for (let 과일 of 과일상자) {console.log(과일);}

// 8. <ol> 안에 <li>로 HTML에 출력
let studentArray = ['유재석', '강호동', '신동엽'];

let HTML = ``
for (let i=0; i < studentArray.length; i++) {HTML += `<li>${studentArray[i]}</li>`}
document.querySelector('#studentList').innerHTML = HTML

for (let i=0; i < 20; i++) { 
    console.log(`i = ${i}`);
    for (let j=0; j<5; j++) {
        console.log(`>>j = ${j}`)
    }
;} 
console.log('')

// 10. for문 중첩을 이용한 구구단 출력
for (let i=2; i <= 9; i++) {
    console.log(`< ${i} 단 >`);
    for (let j=1; j<= 9; j++) {
        console.log(`${i} X ${j} = ${i*j}`)
    ;}
    console.log('');
;}

// 11.
/*for ( ; ; ) {
    let input = prompt('무한입력중: ');  // prompt, alert, confirm 등 몇 함수들은 입력 받는 동안 코드실행이 멈춤(wait)
    console.log( input );
    if ( input == 'X' || input == 'x' ) { break; }
}
*/

// 12. break; 1~10까지 1씩 증가하며 5이면 반복문 종료
for (let i=1; i<=10; i++) {

    if (i==5) {break;}
    console.log(i);
}


// 13. continue; 5이면 continue
for (let i=1; i<=10; i++) {

    if (i==5) {continue;}
    console.log(i);
}

// 14. 입력받은 데이터를 numArray에 push; 
    // 1. 중복이면 입력은 가능하나 저장은 X
    // 2. 배열 중복 없이 6개의 숫자가 등록되면 반복문 종료
let numArray = [];
for (i=1; i>0; i++) {
    let data = Number(prompt('데이터를 입력: '));
    console.log (data);
    if (numArray.includes(data) == true) continue;
    numArray.push(data);
    if (numArray.length == 6) {console.log(`입력횟수: ${i}회`); break;}
}
console.log (numArray)


