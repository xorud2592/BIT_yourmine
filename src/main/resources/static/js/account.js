var account = {
    init: function () {
        var func = this;
        $('#btn-signup').on('click', function () {
            func.save();
        });

        $('#btn-idCheck').on('click', function () {
            func.idCheck();
        });

        $('#btn-postcode').on('click', function () {
            func.postcode();
        });

        $('#btn-roleChange').on('click', function () {
            func.roleChange();
        });

        $('#id').change(function () {
            $('#idCheck').val("f");
        });
    },

    save: function () {
        if ($('#idCheck').val() != "t"){
            alert("아이디 중복 확인을 해주세요");
            return;
        }
        if ($('#password').val() == "") {
            alert("비밀번호를 입력해주세요");
            return;
        }
        if ($('#password').val() != $('#password2').val()) {
            alert("비밀번호가 일치하지 않습니다");
            return;
        }
        if ($('#name').val() == "") {
            alert("이름을 입력해주세요");
            return;
        }
        if ($('#address').val() == "") {
            alert("주소를 입력해주세요");
            return;
        }
        if ($('#detailAddress').val() == "") {
            alert("상세주소를 입력해주세요");
            return;
        }
        if ($('#phone').val() == "") {
            alert("휴대폰번호를 입력해주세요");
            return;
        }
        var numTest = /^\d{3}-\d{3,4}-\d{4}$/;
        if(!numTest.test($('#phone').val())) {
            alert("휴대폰번호 형식이 잘못되었습니다");
            return;
        }
        var fullAddress = $('#address').val()+" "+$('#detailAddress').val();
        var data = {
            name: $('#name').val(),
            id: $('#id').val(),
            password: $('#password').val(),
            phone: $('#phone').val(),
            address: fullAddress
        };
        $.ajax({
            type: 'POST',
            url: "/signup",
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원가입 되었습니다');
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    idCheck: function () {
        if ($('#id').val().length == 0) {

            var con = "<p>ID를 입력해주세요</p>";
            $('#msg').empty();
            $('#msg').append(con);
            return;
        }
        var data = {
            id: $('#id').val()
        };
        $.ajax({
            url: "/idCheck",
            type: "Post",
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data),
            success: function(result) {
                if ( result.data != true) {
                    $('#idCheck').val("f");
                    var con = "<p style=\"color:red;\">사용할 수 없는 ID입니다</p>";
                    $('#msg').empty();
                    $('#msg').append(con);
                    alert("이미 가입된 ID입니다");
                } else {
                    $('#idCheck').val("t");
                    var con = "<p style=\"font-size: 1em;\">사용 가능합니다</p>";
                    $('#msg').empty();
                    $('#msg').append(con);
                    alert("가입하실수 있는 ID입니다");
                }
            },
            error: function(error) {
                console.error(error);
                $('#idCheck').val("f");
            }
        });
    },

    postcode: function () {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAddress").value = extraAddr;

                } else {
                    document.getElementById("extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
    },

    roleChange: function () {
        if ($('#address').val() == "") {
            alert("주소를 입력해주세요");
            return;
        }
        if ($('#detailAddress').val() == "") {
            alert("상세주소를 입력해주세요");
            return;
        }
        if ($('#phone').val() == "") {
            alert("휴대폰번호를 입력해주세요");
            return;
        }
        var numTest = /^\d{3}-\d{3,4}-\d{4}$/;
        if(!numTest.test($('#phone').val())) {
            alert("휴대폰번호 형식이 잘못되었습니다");
            return;
        }
        var fullAddress = $('#address').val()+" "+$('#detailAddress').val();
        var data = {
            id: $('#id').val(),
            phone: $('#phone').val(),
            address: fullAddress
        };
        $.ajax({
            type: 'POST',
            url: "/roleChange",
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('수정되었습니다');
            window.location.href = "/mypage";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

account.init();