function popImg(url){
    System.showDialog(url,{width:800, height:500,title:"图片展示"});
}

function cancel(){
    System.closeDialog();
}

function backbox() {
    var area = $("#back").html();
    System.showDialog(area,{width:500, height:400,title:"驳回原因"});
}
