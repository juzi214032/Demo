//判断用户输入的电子邮箱格式是否正确
function checkEmail() {
    var myforms = document.forms;
    var myemail = myforms[0].email.value;
    var myReg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;

    if (myReg.test(myemail)) {
        return true;
    } else {
        // myspan.innerText="邮箱格式不对!";
        alert("邮箱格式不对！")
        $("#email").val("");
        return false;
    }
}

$(function () {
    $(document).on("click", "#button-send", function () {
        // $('#form-register').off().on('click', function(){
        if (checkEmail()) {
            $.ajax({
                cache: false,
                type: "POST",
                url: "/code",
                data: $("#form-register").serialize(),
                async: true,
                success: function (data) {
                },

            });
            alert("验证码发送成功，请到邮箱查看验证码！")

        }
    });
})

