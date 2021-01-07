function isLogin(t,v,u) {
    const uid = u;
    const vid=v;
    const type=t;

    if(type == 1)
        window.location.href='/order/page?key=attraction&tpVid='+vid+'&tpUid='+uid;
    else if(type == 2)
        window.location.href='/order/page?key=hotel&tpVid='+vid+'&tpUid='+uid;
    // else if(type== 3)
    //     window.location.href='/order/orderPage?key=traffic&tpVid='+vid+'&tpUid='+uid;

}

function cancelOrder() {
    // var type=t;
    var s=confirm("确定要取消订单么？");
    if(s==true){
        alert("取消订单成功！返回主页面！");
        window.location.href='/order/cancelSubmit';
    }



}

function submitOrder(a) {

    // const orderid=document.getElementById("orderId").value;
    // const uid=document.getElementById("uId").value;
    // const ordername=document.getElementById("orderName").value;
    // const orderplace=document.getElementById("orderPlace").value;
    // const email=document.getElementById("inputEmail").value;
    // const phone=document.getElementById("inputPhone").value;
    // const cost=document.getElementById("ocost").value;
    // const create=document.getElementById("createtime").value;
    // const createDate=create.split(" ")[0];
    // const createTime=create.split(" ")[1];
    const booktime=document.getElementById("booktime").value;
    const option=a;
    const form=document.getElementById("form");
    if(booktime==""){
        alert("请填写预订日期！");
    }else{
        // window.location.href='/view/submit?key=attraction&orderid='+orderid+"&uid="+uid+"&ordername="+ordername+"&orderplace="+orderplace+"&email="+email+
        //     "&phone="+phone+"&cost="+cost+"&createDate="+createDate+"&createTime="+createTime+"&booktime="+booktime;
        alert("提交订单成功！");
        // if(option==1)
        //     window.location.href='/order/commit?key=attraction&booktime='+booktime;
        // else if(option==2){
        //     window.location.href='/order/commit?key=hotel&booktime='+booktime;
        // }
        form.submit();
    }

}

function isDelete(uid,oid) {
    // alert("删除");
    var o=oid;
    var u=uid;
    var s=confirm("确定要删除么？");

    if(s==true){
        alert("删除成功！");
        window.location.href='/order/orderDelete?tp_oid='+o+'&uid='+u;
    }
}

