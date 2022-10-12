document.getElementById('btn_signin').onclick = function(event){
    var pw = document.getElementById('pw');
    if(pw.value == '') {                        // pw값이 없으면
        alert('비밀번호를 입력하세요.');        // alert창 띄우기(동작을 막지 않으면 '확인'버튼을 클릭하면 로그인 실행됨.)
        event.preventDefault();                 // button의 기본 동작이 submit임. button의 기본 동작을 막음(Default)
        return;                                 // '확인' 클릭 후 실행되지 않도록 막음(return를 입력하지 않으면 다른 코드가 있을 시, 실행될 수 있으므로 입력 필요)
    }
}
document.getElementById('id').onkeyup = function(event){     // 아이디 값 작성 할때 마다 : onkeyup
    var id = document.getElementById('id');
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0){                                 // String값의 길이 구하기     // if(id.value.length == 0) : 한글자도 입력하지 않으면
        id_msg.textContent = '';
    } else if(id.value.length < 4) {
        id_msg.textContent = '아이디는 4자 이상입니다.';      // ex) 아이디가 3자인 상태에서 로그인해도 실행 됨.(submit를 막아야함)
    } else if(id.value.length >= 4) {
        id_msg.textContent = '정상적인 아이디입니다.';
    }
}