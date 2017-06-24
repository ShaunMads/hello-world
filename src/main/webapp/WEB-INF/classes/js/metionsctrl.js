$(document).ready(function () {
    //按钮高亮
    $('#metionsctrl').addClass('active');
    //显示增加框


    //summernote配置
    $('#editor').summernote({
        height: 300,
        lang: 'zh-CN',
        toolbar: [
            ['style', ['style']],
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['insert', ['picture', 'link']],
            ['table', ['table']], 
            //['help', ['help']] //no help button
        ],
        onImageUpload: function (files, editor, $editable) {
            sendFile(files[0], editor, $editable);
        }
    });
    //提交表单
    $('#submitbtn').click(function () {
        var editorvalue = $('#editor').code();
        $("#content").attr('value', editorvalue);
        $("#addform").submit();
    });
    $('#cancelbtn').click(function(){
        $('#addform').hide();
        $('#days').val('');
        $('#editor').code('');
    })
    
    // 术后信息列表
    var idList="";
    for(var i = 0; i < tipsList.length; i++){

        idList+=tipsList[i].contentId+" ";
        // 列表项
        var temp = $('<tr/>');
        $('<td/>').html(tipsList[i].title)
                  .attr('value', tipsList[i].contentId)
                  .append($('<span/>').attr('class','drop-down'))
                  .appendTo(temp);
        $('<td/>').append($('<div/>')
            .attr('class','btn btn-default btn-xs btn-edit')

                .html(''))
                  .appendTo(temp);

        // 详细内容
        var tempcontent = $('<tr/>').hide();
        $('<td/>').html('价格：'+tipsList[i].price+'数量：'+quantityList[i])
                  .attr('colspan','2')
                  .appendTo(tempcontent);
        // 添加行
        $('#metionstable').append(temp)
                          .append(tempcontent);
    }
     console.log(idList);
    $('#purchase').click(function () {
        $('#cartContent').val(idList)
    });

//编辑、删除
    $('.btn-edit').click(function(){
        $('#addform').attr('action','/admin/editTip.do');
        $('#addform').show();
        $('#days').value($('.btn-edit').tldays);
        $('#content').value($('.btn-edit').ylcontent);
        $('#nid').value($('.btn-edit').tipid);
        });
   /* $('#editbtn').click(function () {
        $('#addform').attr('action','/admin/editTip.do')
        $('#addform').show();
        var editBtn = document.getElementById("editbtn");
        $('#days').value(editBtn.tldays);
        $('#content').value(editBtn.ylcontent);
        $('#nid').value(editBtn.tipid);
    });*/

    // 下拉按钮
    $('span.drop-down').click(function(){
        if(this.state == null){//设置初始状态
            this.state = 0
        }
        if(this.state == 0){//展开
            $(this).parent().parent().next().show();
            $(this).attr('class','pull-up');
            this.state = 1;
        }else{//收起
            $(this).parent().parent().next().hide();
            $(this).attr('class','drop-down');
            this.state = 0;
        } 
    });
});

//图片上传函数
function sendFile(file, editor, $editable) {
    $(".note-toolbar.btn-toolbar").append('正在上传图片');
    var filename = false;
    try {
        filename = file['name'];
        console.log(filename);
    } catch (e) {
        filename = false;
    }
    if (!filename) {
        $(".note-alarm").remove();
    }
//以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误  
    var ext = filename.substr(filename.lastIndexOf("."));
    ext = ext.toUpperCase();
    var timestamp = new Date().getTime();
    var name = timestamp + "_" + $("#editor").attr('aid') + ext;
//name是文件名，自己随意定义，aid是我自己增加的属性用于区分文件用户
    data = new FormData();
    data.append("upfile", file);
    console.log(file);

    $.ajax({
        data: data,
        type: "POST",
        url: "/commonUpload.do", //图片上传出来的url，返回的是图片上传后的路径，http格式
        cache: false,
        processData: false,
        contentType: false,
        success: function (url) {
//url是返回的hash,key之类的值，key是定义的文件名  
            console.log(url);
//把图片放到编辑框中。editor.insertImage 是参数，写死。后面的http是网上的图片资源路径。  
//网上很多就是这一步出错。  
            $('#editor').summernote('editor.insertImage', url);

            $(".note-alarm").html("上传成功,请等待加载");
            setTimeout(function () {
                $(".note-alarm").remove();
            }, 3000);
        },
        error: function () {
            $(".note-alarm").html("上传失败");
            setTimeout(function () {
                $(".note-alarm").remove();
            }, 3000);
        }
    });
}