/*

    연산자: 연산시 사용되는 기호

    1. 산술연산자 => 게산 결과
        + 더하기    - 빼기     * 곱하기     / 나누기     % 나머지
            몫? = parseInt( ) : 정수 반환 함수;  parseInt(n/m) : n을 m으로 나눈 몫

            // prompt( ) : string으로 입력됨; 숫자로 변환하기 -> 1. *1   2. Number( )
            // 숫자 -> 문자로 변환하기 : 1. 10 + "" = "10"  2. String( )
    

    2. 연결연산자 => 연결 결과

        숫자 + 숫자 : 더하기
        숫자 + 문자 : 연결
        문자 + 문자 : 연결
        변수 + 숫자 : 문자변수/연결, 숫자변수/더하기
        문자 + 숫자1 + 숫자2 : 앞에서부터 -> 연결
        문자 + (숫자1 + 숫자2) : 소괄호 먼저
        
        -> 피연산자에 문자가 포함되면 연결


    3. 비교연산자 => true false

        > 초과/크다          >= 이상/크거나 같다
        <                   <=
        == [값]같다          === [값과 타입 모두] 같다 (강력비교)  // 10 == "10" true    10 === "10" false
        != 같지 않다         !== 타입도 같지 않다


    4. 관계연산자 : 비교연산자가 두개 이상일 때, => true false

        &&  AND조건 /이면서, 모두       // true && false = false

        ||  OR조건 /이거나, 하나라도    // true || false = true

        !   NOT조건 /부정, 반대         // !true = false,   !false = true

    5. 대입연산자
        =   대입 > 오른쪽 데이터를 왼쪽에 대입

        +=  복합대입연산자; 오른쪽 데이터를 왼쪽에 더한 후 왼쪽에 대입
        -= *= /= %= 등

    6. 증감연산자
        ++  1 증가  [ 선위증가 : ++변수, 후위증가 : 변수++ ]
        --  1 감소
        *선위 후위 기준 : ";" 안에서

    7. 삼항연산자 
        1. 조건 ? 참값 : 거짓값
        2. 조건1 ? 참1 : 조건2 ? 참2 : 거짓
*/

// 문제1

/*let 국어 = Number(prompt('국어점수: ')); let 영어 = Number(prompt('영어점수: ')); let 수학 = Number(prompt('수학점수: '));
let 총점 = 국어 + 영어 + 수학; let 평균 = (국어 + 수학 + 영어) / 3;
console.log (`총점: ${총점}, 평균: ${평균}`) */

// 문제2

/* let 반지름 = Number(prompt('반지름: '));
let 원넓이 = 반지름 * 반지름 * 3.14;
console.log (`원넓이: ${원넓이}`) */

// 문제3

/*let num1 = Number(prompt('실수1: ')); let num2 = Number(prompt('실수2: '));
let 비율 = num1 / num2 * 100;
console.log (`비율: ${parseInt(비율)}%`) */


// 3. 비교연산자
/*console.log(10>3); // true 
console.log(10 != "10") // false (값이 같으므로)
console.log(10 !== "10") // true (값은 같지만 타입이 다르다)
console.log("10" != "10") // false (값과 타입 모두 같다) */

// 4. 관계연산자
/* true && false = false
false && false = false
true || false = true
false || false = false
!false = true */

// 문제 4. 홀수 = true, 짝수 = false
/* let num = Number(prompt("정수: "));
console.log(parseInt(num%2) > 0); */

// 문제 5.
/* let num = Number(prompt("정수: "));
console.log(parseInt(num%7) == 0); */

// 문제 6.
/* let id = prompt('아이디: '); let password = prompt('비밀번호: ');
console.log(id == 'admin' && password == '1234'); */

// 문제 7. 홀수 + 7의 배수 = true
/* let num = Number(prompt("정수: "));
let 결과 = num%2 == 1 && num%7 == 0;
console.log(결과); */

// 문제 8.

/*  1. let mon = prompt('십만원 단위의 금액: ');
    console.log(`십만원: ${mon[0]}장, 만원: ${mon[1]}장, 천원: ${mon[2]}장`) 

    2. let mon = prompt('십만원 단위의 금액: ');
    let 십만원권 = parseInt(mon/100000);
    let 만원권 = parseInt((mon/10000)%10);
    let 천원권 = parseInt((mon/1000)%10);
    console.log(`십만원: ${십만원권}장, 만원: ${만원권}장, 천원: ${천원권}장`)

    3. let mon = prompt('십만원 단위의 금액: ')
    let 십만원권 = parseInt(mon/100000);
    mon = mon - 십만원권*100000;
    let 만원권 = parseInt(mon/10000);
    mon = mon - 만원권*10000;
    let 천원권 = parseInt(mon/1000);
    console.log(`십만원: ${십만원권}장, 만원: ${만원권}장, 천원: ${천원권}장`) */

// 대입연산자

/*let 변수 = 10;
    변수 = 변수 + 3;*/
//    1  2  3  4  5   실행순서 : 3(변수호출) 4(연산) 5(연산) 2 1

/*변수 += 3; // 오른쪽 값을 왼쪽에 더한 후 왼쪽에 결과를 대입
변수 -= 3; 
변수 *= 2;*/

// 증감연산자

/*let num = 10
console.log(num++); // 10  / 1. 변수호출 2. 출력  3. 1 증가 (후위증가) ";"
console.log(num); // 11 

console.log(++num); // 12  / 1. 변수호출 2. 1 증가 (선위증가) 3. 출력  ";"

console.log(num--); // 12  / 12에서 출력후 1 감소
console.log(--num); // 10  / 11에서 1 감소후 출력*/

// 삼항연산자

let 점수 = 85;
console.log(점수 >= 90);  // false
console.log(점수 >= 90 ? '합격' : '불합격')

let age = 39;
console.log(age >= 19); // true
console.log(age >= 19 ? '성인' : '청소년') // true => '성인'
console.log(age >= 40 ? '중년' : age >= 19 ? '성인' : '청소년') // 1. false 2. true => '성인'
