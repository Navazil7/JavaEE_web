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
    // var s=confirm("确定要取消订单么？");
    // if(s==true){
    //     alert("取消订单成功！返回主页面！");
    //     window.location.href='/order/cancelSubmit';
    // }

    layer.open({
        type:1,
        area:'auto',
        skin:'layui-layer-rim',
        title:'取消订单确认',
        shade:0,
        content:"确定要取消订单吗？",
        btn:['拜拜了您嘞','桥洞麻袋'],
        yes:function () {
            layer.alert("取消订单成功！返回主页面！",{icon:4,time:3000},function () {
                window.location.href='/order/cancelSubmit';
            });

        }

    })


}

function submitOrder() {

    const booktime=document.getElementById("booktime").value;
    const num=document.getElementById("num").value;
    const form=document.getElementById("form");
    if(booktime==""){
        layer.alert("请填写预订日期！",{icon:5});
    }
    else if(num==""){
        layer.alert("请选择订单数量！",{icon:5})
    }
    else{
        layer.open({
            type:1,
            // area:['200px','150px'],
            area:'aoto',
            skin:'layui-layer-rim',
            title:'订单确认',
            shade:0,
            content:'<div style="font-family: arial, sans-serif;vertical-align: middle;text-align: center">确定要提交订单么？</div>',
            btn:['确定','再考虑一下'],
            anim:3,
            btn1:function () {
                layer.closeAll();
                layer.alert("<div id='pay'>提交订单成功！请支付！60s后未点击确定按钮订单将失效</div>",{icon:6},function () {


                    layer.closeAll();
                    window.clearInterval(id1);


                    var img = '<img id="paycode" src="/static/upload/img/payQrcode200x200.png" alt="loading..."/>'


                    layer.open({
                        type: 1,//Page层类型
                        // area: ['200px', '250px'],
                        area:'auto',
                        title: '请扫码支付',
                        shade: 0.6 ,//遮罩透明度
                        maxmin: true ,//允许全屏最小化
                        anim: 1 ,//0-6的动画形式，-1不开启
                        content: img,
                        btn: ['已付款', '容朕想想'],
                        yes: function(index, layero) {
                            layer.closeAll();
                            layer.alert("<div id='info'>恭喜你，付款成功！您将在3秒后自动跳转到订单页面...</div>",{icon:1,time:3000},function () {
                                form.submit();
                            });
                            var t=2;
                            var id = window.setInterval(function doUpdate(){

                                document.getElementById("info").innerHTML='恭喜你，付款成功！'+'您将在'+t+'秒后自动跳转到订单页面...';
                                if(t==0) {
                                    window.clearInterval(id);
                                    form.submit();
                                }
                                t--;
                            }, 1000);


                        },
                        cancel: function() {
                            //右上角关闭回调
                            layer.closeAll();
                        }
                    });
                });

                var time=59;
                var id1 = window.setInterval(function doPass(){

                    document.getElementById("pay").innerHTML='提交订单成功！请支付！'+time+'s后未点击确定按钮订单将失效...';
                    if(time==0) {
                        window.clearInterval(id1);
                        layer.alert("订单已失效！",{icon:2})
                    }
                    time--;
                }, 1000);


            },
            btn2:function () {
                // layer.closeAll();
            }
        });


    }

}



function isDelete(uid,oid) {
    // alert("删除");
    var o=oid;
    var u=uid;
    layer.open({
        type: 1,//Page层类型
        area:'auto',
        title: '删除订单确认',
        shade: 0.6 ,//遮罩透明度
        maxmin: false ,//不允许全屏最小化
        anim: 4 ,//0-6的动画形式，-1不开启
        content: "确定要删除订单么？<p style='color: red'>一经删除，无法撤回！</p>",
        btn: ['gkd', '容朕想想'],
        yes:function () {
            layer.alert("删除成功！",{icon:1},function () {
                window.location.href='/order/orderDelete?tp_oid='+o+'&uid='+u;
            });

        }
    })
}

