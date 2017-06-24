$(document).ready(function () {
    $('#hospitalmsg').addClass('active');
    $('#addhospitalmsg').click(function () {
        $('#addform').show();
    });
    $('#cancelbtn').click(function () {
        $('#addform').hide();
        $('#hospitalname').val('');
    });
    // 医院信息列表
    for (var i = 0; i < titleList.length; i++) {
        var temp = $('<tr/>');
        $('<td/>').html(titleList[i]).appendTo(temp);
        $('<td/>').html(timeList[i]).appendTo(temp);
        $('<td/>').html(quantityList[i]).appendTo(temp);

        $("#hospitaltable").append(temp);
        console.log(timeList[i]);
    }


    // 编辑按钮
    $('.btn-edit').click(function () {
        if (this.state == null) {//设置初始状态
            this.state = 0;
        }

        if (this.state == 0) {//编辑状态
            $(this).next().hide();
            $(this).html('提交');
            // 获取value
            var msgValue = $(this).parent().prev().html();
            var inputbox = $('<input/>').val(msgValue);
            $(this).parent().prev().html(inputbox);

            this.state = 1
        } else {//提交状态
            $(this).next().show();
            $(this).html('编辑');

            var msgValue = $(this).parent().prev().children().val();
            $(this).parent().prev().html(msgValue);

            this.state = 0
        }
    });
});