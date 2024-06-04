/**
 *  - 브라우저 세션과 쿠키
 *      f12 > application > 1. localStorage 2. sessionStorage
 *      
 *      - JS 실행시점 : http 이용한 html 요청할때 -> html 열렸을 때(html에 JS 포함됨)
 *      - F5(재요청) : 현재 http(주소) 재요청 -> html -> js ( 메모리 초기화 )
 *          - JS 메모리 영구 저장 -> 외부 요소 이용
 *              1. Database(DB)  2. 브라우저(프로그램)  3. 자바(서버)
 * 
 *  - 브라우저 저장소 (보안 취약)
 *      1. localStorage 객체    : 브라우저 꺼져도 유지, 유저가 직접 삭제 (활용: 자동로그인 등)
 *      2. sessionStorage 객체  : 브라우저 꺼지면 제거 (활용: 임시 데이터; 뒤로가기, 검색엔진)
 *          - 속성
 *             .setItem('Key', value);  : 세션/쿠키에 key 와 value 쌍으로 데이터 저장
 *             .getItem('Key', value);  : 세션/쿠키에 value 호출
 *                 - value : 문자 데이터 형식만 가능
 * 
 *  객체 <---> 문자
 *    - JSON(자바스크립트 객체 형식)
 *    1. JSON.stringify({ }) : 객체를 문자열로
 *    2. JSON.parse( '{"",""}' ) : 문자열을 객체로
 * 
 *   - 데이터형식/형식과 값은 다르다.
 *      '3' : 값은 숫자지만 형식은 문자열
 *      "{이름 : '유재석'}" 값은 객체지만 형식은 문자열
 */

// 1. 
//localStorage.setItem('이름', '유재석');
console.log(localStorage.getItem('이름'))

//sessionStorage.setItem('나이', '40')
console.log(sessionStorage.getItem('나이'))

// 2.
localStorage.setItem('객체', {이름 : '유재석', 나이 : '40'})
console.log(localStorage.getItem('객체'))

// 3.
console.log(JSON.stringify({"이름" : "유재석"}))
console.log({이름 : '유재석'})
console.log(JSON.parse(  '{"이름" : "유재석"}' ) )  // JSON 양식 : 속성명에 큰따옴표만 인식

// 4.
localStorage.setItem('저장소', JSON.stringify({국어 : '30', 영어 : '50'})) // {"국어" : "30", "영어" : "50"}
console.log(JSON.parse(localStorage.getItem('저장소')))