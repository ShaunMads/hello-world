$(document).ready(function() {
	//按钮高亮
    $('#newsctrl').addClass('active');
    //显示增加框
    $('#addnews').click(function() {
        $('#addform').attr('action','/content/addContent.do');
        $('#addform').show();
    });

    //summernote配置
    $('#editor').summernote({
    	height: 300,
    	lang:'zh-CN',
    	toolbar: [
				    ['style', ['style']], 
				    ['style', ['bold', 'italic', 'underline', 'clear']],
				    ['fontsize', ['fontsize']],
				    ['color', ['color']],
				    ['para', ['ul', 'ol', 'paragraph']],
				    ['height', ['height']],
				    ['insert', ['picture', 'link']],
				    ['table', ['table']], // no table button
				    //['help', ['help']] //no help button
				  ],
	    onImageUpload: function(files, editor, $editable) {
		    sendFile(files[0],editor,$editable); 
		}
    });

    //提交表单
    $('#submitbtn').click(function() {
    	var editorvalue = $('#editor').code();
    	$("#content").attr('value',editorvalue);
    	$("#addform").submit();
    });
    $('#cancelbtn').click(function(){
        $('#addform').hide();
        $('#title').val('');
        $('#editor').code('');
    })

    // 新闻列表
    for(var i = 0; i < contentList.length; i++){
        console.log(contentList.length);
        console.log("contentId"+contentList[i].contentId);
        // 列表项
        var temp = $('<tr/>');
        var title = contentList[i].title;
        var id = contentList[i].contentId;
        var img = contentList[i].contentPic;
        var num = 1;

        var content = contentList[i].text;
        var summary = contentList[i].summary;
        var price=contentList[i].price;
        var path=contentList[i].contentPic;

        $('<td/>').html(contentList[i].title)/*.click(function(tit,con) {
            return  function(){
                $('#addcontent').show();
                $('#goodtitle').html(tit);
                $('#goodpic').attr('src','/upload/news/50bb2b92461fd98973ded93b9bc83172.jpg');
                $('#addcontent')
                    .append($('<br/>'))
                    .append($('<div id="addnum"/>')
                    .css({"width":"30px","height":"30px","backgroundColor":"#CCC","fontSize":"20px","textAlign":"center","lineHeight":"30px","cursor":"pointer","float":"left","border":"none"}).html('-').click(function(){
                    num--;
                    if(num < 0){
                        alert('购买数量必须大于0');
                    }else{
                        $('#num').val(num);
                    }
                }))
                    .append($('<input type="text" name="num" id="num"/>').val(num).css({"width":"45px","height":"30px","fontSize":"20px","textAlign":"center","lineHeight":"30px","float":"left" }))
                    .append($('<div id="subnum"/>')
                        .css({"width":"30px","height":"30px","backgroundColor":"#CCC","fontSize":"20px","textAlign":"center","lineHeight":"30px","cursor":"pointer","float":"left","border":"none"})
                        .html('+').click(function(){
                            num++;
                            $('#num').val(num);
                    }))
                    .append($('<div/>').css({"clear":"left"}))
                    .append($('<input type="submit" value="购买"/>').css({"marginTop":"10px","backgroundColor":"#337ab7","color":"#FFF","borderColor":"#2e6da4"}))
                    .append($('<input type="text" name="goodsID" id="goodsID" type="hidden"/>  ').val(id)/!*.css({"diaplay":"none" })*!/)


            }
        }(title,content))*/
            .append($('<image style="width: 45px ;height: 50px;"/>').attr('src',img))
                  /*.
                  .attr('id', contentList[i].nid)*/
                  .append($('<span/>').attr('class','drop-down'))

                  .appendTo(temp);
        $('<td/>').append($('<div/>').attr('class','btn btn-default btn-xs').html('编辑')
            .click(function(tit,con,pri,sum,contentId) {
                   return  function(){
                                $('#addform').show();$('#addform').attr('action','/content/editContent.do');

                                $('#title').val(tit);
                                $('#content').val(con);
                                $('#price').val(pri);
                                $('#summary').val(sum);
                                $('#contentId').val(contentId);
                    }
                }(title,content,price,summary,id))
        )
                  .append($('<div/>').attr('class','btn btn-default btn-xs').append($('<a/>').attr('href','/content/deleteContent.do?nid='+id).html('删除'))

            )
                  .appendTo(temp);
        // 详细内容       
        var tempcontent = $('<tr/>').hide();

        $('<td/>').html('已售数量：'+contentList[i].saleQuantity)
                  .appendTo(tempcontent);
        // 添加行
        $('#newstable').append(temp)
                       .append(tempcontent);
    }

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

//图片上传
function sendFile(file, editor, $editable){  
$(".note-toolbar.btn-toolbar").append('正在上传图片');  
var filename = false;  
try{  
filename = file['name'];  
console.log(filename);  
} catch(e){filename = false;}  
if(!filename){$(".note-alarm").remove();}  
//以上防止在图片在编辑器内拖拽引发第二次上传导致的提示错误  
var ext = filename.substr(filename.lastIndexOf("."));  
ext = ext.toUpperCase();  
var timestamp = new Date().getTime();  
var name = timestamp+"_"+$("#editor").attr('aid')+ext;  
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
success: function(url) {  
//url是返回的hash,key之类的值，key是定义的文件名  
console.log(url);  
//把图片放到编辑框中。editor.insertImage 是参数，写死。后面的http是网上的图片资源路径。  
//网上很多就是这一步出错。  
$('#editor').summernote('editor.insertImage', url);  
  
$(".note-alarm").html("上传成功,请等待加载");  
setTimeout(function(){$(".note-alarm").remove();},3000);  
},  
error:function(){  
$(".note-alarm").html("上传失败");  
setTimeout(function(){$(".note-alarm").remove();},3000);  
}  
}); 
}