<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--首次登陆 用户喜好填写--%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="userliketable" tabindex="-1" role="dialog" aria-labelledby="userModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="closeMsg()">
                    &times;
                </button>
                <h4 class="modal-title" id="userModalLabel">
                    关于旅游的个人喜好
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="userlike" role="form" action="/user/userlike" method="post">
                   <div class="form-group" style="display:none">
                       <input type="hidden" name="uid" value="${user.uid}">
                   </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">偏爱的景点类型</label>
                        <c:forEach items="${set}" var="vtype" >
                            <div class="checkbox-inline">
                                <label><input type="checkbox" value="${vtype}" name="tp_like">${vtype}</label>
                            </div>
                        </c:forEach>
                    </div>
<%--                    <div class="form-group">--%>
<%--                        <label class="col-sm-2 control-label">更喜欢哪个旅游方式</label>--%>
<%--                        <div class="radio-inline"><label><input type="radio" value="跟团游"  name="tp_like">跟团游</label></div>--%>
<%--                        <div class="radio-inline"><label><input type="radio" value="自由行"  name="tp_like">自由行</label></div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label class="col-sm-2 control-label">其他事项</label>--%>
<%--                        <textarea class="form-control" rows="3" name="tp_like"></textarea>--%>
<%--                    </div>--%>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">拒绝设置
                </button>

                <button id="submitBtn" type="button" class="btn btn-primary"  onclick="add_info()" >
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div>
</div>
<script>
    function add_info()
    {
        var form = document.getElementById('userlike');
        form.submit();
        $("#userliketable").on("hidden.bs.modal", function() {
            $(this).removeData("bs.modal");
        });

    }
</script>