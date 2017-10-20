$(function() {
	$(".js-changephoto").on("click", function() {
		$(".dialog").show();
	});
	$(".js-close").on("click", function() {
		$(".dialog").hide();
	});

	$(".tab li").on("click", function() {
		$(this).addClass("active").siblings().removeClass("active");
		$(".tab-content02").hide().eq($(this).index()).show();
	});

	$(".JS-edit").on("click", function() {
		$(".okdiv").hide();
		$(".editdiv").show();
	});
	$(".JS-preservation").on("click", function() {
		$(".editdiv").hide();
		$(".okdiv").show();
	});

	$(".js-add").on("click", function() {
		$(".sytgl-t").show();
	});
	$(".js-close").on("click", function() {
		$(".dialog").hide();
	});
	$(".js-look").on("click", function() {
		$(".sytglxq-t").show();
	});
	$(".js-edit-table").on("click", function() {
		$(".sytglxq-t").hide();
		$(".sytglbj-t").show();
	});
	$(".js-del").on("click", function() {
		$(".deldiv-t").show();
	});
	$(".js-acountmag").on("click", function() {
		$(".xzzhgl").show();
	});
	$(".js-addacount").on("click", function() {
		$(".xzzhglzh-t").show();
	});
	$(".js-release").on("click", function() {
		$(".release-t").show();
	});
	$(".js-ljxj").on("click", function() {
		$(".ggxj-t").show();
	});
	$(".js-dhmx").on("click", function() {
		$(".dhmx-t").show();
	});
	$(".js-sj").on("click", function() {
		$(".sj-t").show();
	});
	$(".js-xj").on("click", function() {
		$(".xj-t").show();
	});
	$(".js-xnfh").on("click", function() {
		$(".xnfh-t").show();
	});
	$(".js-stfh").on("click", function() {
		$(".stfh-t").show();
	});
	$(".js-yhzt").on("click", function() {
		$(".yhzt-t").show();
	});
	$(".js-xnfhxq").on("click", function() {
		$(".xnfhxq-t").show();
	});
	$(".js-stfhxq").on("click", function() {
		$(".stfhxq-t").show();
	});
	$(".js-yhztxq").on("click", function() {
		$(".yhztxq-t").show();
	});

	$(".js-wsc").on("click", function() {
		if ($(this).hasClass("active")) {
			$(".t-tips").show();
			$(this).removeClass("active");
		} else {
			$(this).addClass("active");
		}
	});

	$(".firstmenu .title").on("click", function() {
		if ($(this).hasClass("active")) {
			$(this).removeClass("active");
			$(this).parent().children(".secondmenu").hide();
		} else {
			$(".firstmenu").parent().siblings().find(".title").removeClass("active");
			$(this).addClass("active");
			$(".firstmenu").parent().siblings().find(".secondmenu").hide();
			$(this).parent().children(".secondmenu").show();
		}
	});
	$(".secondmenu span").on("click", function() {
		$(".firstmenu").parent().siblings().find(".secondmenu span").removeClass("active");
		$(this).addClass("active");

	});

	$(".tab li").on("click", function() {
		$(this).addClass("active").siblings().removeClass("active");
		$(".tab-content").hide().eq($(this).index()).show();
	});

});