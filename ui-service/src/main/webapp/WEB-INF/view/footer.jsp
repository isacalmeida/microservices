<%@ page contentType='text/html;charset=ISO-8859-1' %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Footer </title>
</head>
<body>

<script src="${pageContext.request.contextPath}/webjars/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/AdminLTE/2.4.15/dist/js/adminlte.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/AdminLTE/2.4.15/dist/js/demo.js"></script>
<script src="${pageContext.request.contextPath}/webjars/font-awesome/5.9.0/js/fontawesome.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.pt-BR.min.js" charset="UTF-8"></script>
<script src="${pageContext.request.contextPath}/webjars/jquery-mask-plugin/1.14.15/dist/jquery.mask.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/select2/4.0.7/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/select2/4.0.7/js/i18n/pt-BR.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap-switch/3.3.4/dist/js/bootstrap-switch.min.js"></script>

<script>
$('.datepicker').datepicker({
	autoclose: true,
	calendarWeeks: true,
	format: 'dd/mm/yyyy',
	language: 'pt-BR',
	showOnFocus: false,
	todayBtn: 'linked',
	todayHighlight: true
});
</script>

<script>
$(document).ready(function(){
	var optionsData = {
		clearIfNotMatch: true
	};
	$('input[name*=\'data\']').mask('00/00/0000', optionsData);
	
	var optionsCpf = {
		clearIfNotMatch: true
	};
	$('input[name=\'cpf\']').mask('000.000.000-00', optionsCpf);
	
	var optionsDinheiro = {
		clearIfNotMatch: true,
		reverse: true
	};
	$('.mask_dinheiro').mask("##0.00", optionsDinheiro);
});
</script>

<script>
$(function () {
	//Initialize Select2 Elements
	$('.select2').select2({
		placeholder: "",
		language: "pt-BR",
		width: '100%'
	});
});
$("button[data-select2-open]").click(function() {
	$("#" + $(this).data("select2-open")).select2("open");
});
</script>

<script>
    $('.bootstrap-switch')
        .bootstrapSwitch('setOnClass', 'success')
        .bootstrapSwitch('setOffClass', 'danger')
        .bootstrapSwitch('setOnLabel', 'Sim')
        .bootstrapSwitch('setOffLabel', 'Não');

</script>

</body>
</html>
