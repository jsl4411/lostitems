<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="keywords" content="sansillyung, gxsx, bitcamp">
		<meta name="description" content="sansillyung - GxSx">
		<meta name="author" content="sansillyung">
		
		<title>GxSx</title>
		
	<link rel="stylesheet" href="../css/beryllium/style.css">
	<link rel="stylesheet" href="../css/beryllium/themify-icons.css">
	<link rel="stylesheet" href="../css/topmenu.css">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../images/coza/icons/favicon.png"/>
	<link rel="stylesheet" type="text/css" href="../vendor/coza/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../fonts/coza/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../fonts/coza/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="../fonts/coza/linearicons-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/slick/slick.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/MagnificPopup/magnific-popup.css">
	<link rel="stylesheet" type="text/css" href="../vendor/coza/perfect-scrollbar/perfect-scrollbar.css">
	<link rel="stylesheet" type="text/css" href="../css/coza/util.css">
	<link rel="stylesheet" type="text/css" href="../css/coza/main.css">
	
	<style>
		.form-control{
			height:30px;
		}
		.csisize{
			height:70px;
		}
	</style>
	
</head>

<body class="animsition">
	
	<!-- Header -->	
	<!-- *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* -->
	<!-- ////////////////////////////////////// 맨 위 메뉴 시작 ////////////////////////////////////// -->
	<header class="header-v4">
		<!-- Header desktop -->
		<div class="container-menu-desktop">

			<div class="wrap-menu-desktop how-shadow1">
				<nav class="limiter-menu-desktop container">
					
					<!-- Logo desktop -->		
					<a href="../gxsx/domain.do" class="logo">
						<img src="../images/003-.png" alt="IMG-LOGO">
					</a>

					<!-- Menu desktop -->
					<div class="menu-desktop">
						<ul class="main-menu">
							<li class="active-menu">
								<a href="../gxsx/domain.do">Home</a>
							</li>

							<li>
								<a href="../gxsx/notice.do?cp=1">Notice</a>
							</li>

							<li class="label1" data-label1="습득물">
								<a href="../finditem/list.do?cp=1">Finditem</a>
							</li>

							<li class="label1" data-label1="분실물">
								<a href="../lostitem/list.do?cp=1">Lostitem</a>
							</li>
							<li>
								 <a href="../gxsx/contact.do">Contact</a>								 
							</li>
						</ul>
					</div>	

					<!-- Icon header -->
					<div class="wrap-icon-header flex-w flex-r-m">
						<ul class="main-menu">					
							<c:if test="${ empty loginuser && empty klogin}">
									<li><i class="zmdi zmdi-account-circle"></i>
										<a href="../gxsx/login.do">Login</a></li>
							</c:if>
							<c:if test="${ !empty loginuser }">
								<li class="dropdown">
							        <li class="dropdown">
							          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							          <i class="ti-bell"></i>(<b>${messageResult.size()}</b>)</a>
							          <c:choose>
							          	<c:when test="${messageResult=='[]'}">
							          		<ul class="dropdown-menu notify-drop" style="right:350px;min-width:100px;max-height:30px">
								            		<div class="drop-content" data-tooltip="tooltip" data-placement="top" style="min-height:10px">
										            	<li><center><div class="col-md-9 col-sm-9 col-xs-9 pd-l0" style="margin-left:15px;">
										            		알람 없음</div></center>
										            	</li>
									            	</div>
									            </ul>
							          	</c:when>
							          	<c:otherwise>
								          	<ul class="dropdown-menu notify-drop" style="right:350px">
									          	<div class="drop-content" data-tooltip="tooltip" data-placement="top">
									          		<c:forEach items="${messageResult}" var="messageResult" varStatus="status" begin="0" end="4">
										            	<li><div class="col-md-9 col-sm-9 col-xs-9 pd-l0" style="margin-left:15px;min-width:250px">
										            		<a href="../Question/questionco.do?qno=${messageResult.qno}">${messageResult.qsub}</a>
										            		<p style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 250px">${messageResult.qcon}</p>
										            		<p class="time">답변완료</p></div>
										            	</li>
										            </c:forEach>
									            </div>
								            </ul>
							          	</c:otherwise>
							          </c:choose>
						            </li>
							    </li>
						    </c:if>
								
						<c:if test="${ !empty loginuser || !empty klogin }">
							<li class="dropdown">
					          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="ti-user"></i></a>
					          <ul class="dropdown-menu notify-drop" style="min-width:150px">
					            <div class="drop-content" data-tooltip="tooltip" data-placement="top" style="min-height:50px; overflow:hidden">							            
					            	<li><div>&nbsp;&nbsp;
											<i class="ti-bookmark-alt"></i>&nbsp;&nbsp;<a href="../Users/mypage.do">마이페이지</a>
					            		</div></li>
					            	<li><div>&nbsp;&nbsp;
					            			<i class="ti-headphone-alt"></i>&nbsp;&nbsp;<a href="../gxsx/contact.do">고객센터</a>
					            		</div></li>
					            	<li><div>&nbsp;&nbsp;
						            		<i class="ti-power-off"></i>
						            		<c:if test="${ empty loginuser && empty klogin}">
						            			&nbsp;<a href="">로그아웃</a>
						            		</c:if>
						            		<c:if test="${ !empty loginuser && empty kakaologout_url}">
												&nbsp;<a href="../gxsx/logout.do">로그아웃</a>
											</c:if>
											<c:if test="${!empty klogin && !empty kakaologout_url}">
												&nbsp;<a href="${kakaologout_url}">로그아웃</a>
											</c:if>
					            		</div></li>
					             </div>
						      </ul>
							</li>
						</c:if>	
						</ul>			
					</div>
				</nav>
			</div>	
		</div>
	</header>
	<!-- ////////////////////////////////////// 맨 위 메뉴 종료 ////////////////////////////////////// -->
	<!-- *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* -->
     
	<!-- *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* -->
	<!-- /////////////////////////////////////// 컨텐츠 시작  /////////////////////////////////////// -->
	<!-- breadcrumb -->
	<div class="container">
		<div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
			<a href="index.do" class="stext-109 cl8 hov-cl1 trans-04">
				Home
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<a href="list.do" class="stext-109 cl8 hov-cl1 trans-04">
				Finditem
				<i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
			</a>

			<span class="stext-109 cl4">
				write
			</span>
		</div>
	</div>
	
	<!-- Content page -->
	<section class="bg0 p-t-62 p-b-60">
		<div class="container">
				<div class="col-md-8 col-lg-9 p-b-80" id="contentchange">

						<div class='m-l-25 m-r--38 m-lr-0-xl fs-12' style='margin-left: 200px'>
							</br>
							</br>
							<div class='table-shopping-cart fs-12'>
								<div class='card-header'>
									<h3 class='mb-0'>분실물 수정</h3>
								</div>
								<div class='card-body fs-12'>
									<form class='form2 fs-12' method='post'  name='input' id='form2' role='form2' enctype='multipart/form-data'
										autocomplete='off' action='update.do'>
										
										<input type="hidden" name="lono" value="${updatef[0].lono}">
										
										
										<div class='form-group row'>
											<label for='noinputId'
												class='col-lg-2 col-form-label form-control-label'>아이디</label>
											<div class='col-lg-10'>
												<input type='text' class='form-control fs-12' id='editId'
													name='userid' value='${loginuser.userid}' readonly='readonly'>
											</div>
										</div>
										
										<div class='form-group row'>
											<label for='inputSub'
												class='col-lg-2 col-form-label form-control-label'>제목</label>
											<div class='col-lg-10'>
											<input class='form-control fs-12' type='text' id='editSub'
													name='losub' value='${updatef[0].losub}' required=''>
											</div>
										</div>
										
										
										<div class='form-group row'>
											<label for='inputDate'
												class='col-lg-2 col-form-label form-control-label'>날짜</label>
											<div class='col-lg-10'>
												
												<input class='form-control fs-12' type='date' id='editDate'
													name='lodate' value='${user.uemail}' required=''>
											</div>
										</div>
										
										<div class='form-group row'>
											<label for='inputArea'
												class='col-lg-2 col-form-label form-control-label'>지역</label>
											<div class='col-lg-3'>
											      <select class="ui fluid dropdown" name="loano" id="ano">
											        	   <option <c:if test="${(updatef[0].loano) == 02}">selected='selected'</c:if> value="02">서울</option>
												        	<option <c:if test="${(updatef[0].loano) == 051}">selected='selected'</c:if> value="051">부산</option>
												        	<option <c:if test="${(updatef[0].loano) == 053}">selected='selected'</c:if> value="053">대구</option>
												        	<option <c:if test="${(updatef[0].loano) == 032}">selected='selected'</c:if> value="032">인천</option>
												        	<option <c:if test="${(updatef[0].loano) == 062}">selected='selected'</c:if> value="062">광주</option>
												        	<option <c:if test="${(updatef[0].loano) == 042}">selected='selected'</c:if> value="042">대전</option>
												      		<option <c:if test="${(updatef[0].loano) == 052}">selected='selected'</c:if> value="052">울산</option>
												        	<option <c:if test="${(updatef[0].loano) == 044}">selected='selected'</c:if> value="044">세종</option>
												        	<option <c:if test="${(updatef[0].loano) == 031}">selected='selected'</c:if> value="031">경기</option>
												        	<option <c:if test="${(updatef[0].loano) == 033}">selected='selected'</c:if> value="033">강원</option>
												        	<option <c:if test="${(updatef[0].loano) == 043}">selected='selected'</c:if> value="043">충북</option>
												        	<option <c:if test="${(updatef[0].loano) == 041}">selected='selected'</c:if> value="041">충남</option>
												        	<option <c:if test="${(updatef[0].loano) == 063}">selected='selected'</c:if> value="063">전북</option>
												        	<option <c:if test="${(updatef[0].loano) == 061}">selected='selected'</c:if> value="061">전남</option>
												        	<option <c:if test="${(updatef[0].loano) == 054}">selected='selected'</c:if> value="054">경북</option>
												        	<option <c:if test="${(updatef[0].loano) == 055}">selected='selected'</c:if> value="055">경남</option>
												        	<option <c:if test="${(updatef[0].loano) == 064}">selected='selected'</c:if> value="064">제주</option>
												        	<option <c:if test="${(updatef[0].loano) == 0}">selected='selected'</c:if> value="0">기타</option>
											      </select>
											</div>
											<label for='inputPlace'
												class='col-lg-2 col-form-label form-control-label' style="text-align:right">분실장소</label>
											<div class='col-lg-5'>
												<input class='form-control fs-12' type='text' id='editPlace'
													name='loplace' value='${updatef[0].loplace}' required=''>
											</div>
										</div>
										
										<div class='form-group row'>
											<label for='inputArea'
												class='col-lg-2 col-form-label form-control-label'>물품종류</label>
											<div class='col-lg-3'>
											      <select class="ui fluid dropdown" name="locname">
											        	<option <c:if test="${(updatef[0].locname) == '가방'}">selected='selected'</c:if> value="가방">가방</option>
														<option <c:if test="${(updatef[0].locname) == '귀금속'}">selected='selected'</c:if> value="귀금속">귀금속</option>
														<option <c:if test="${(updatef[0].locname) == '도서용품'}">selected='selected'</c:if> value="도서용품">도서용품</option>
														<option <c:if test="${(updatef[0].locname) == '서류'}">selected='selected'</c:if> value="서류">서류</option>
														<option <c:if test="${(updatef[0].locname) == '산업용품'}">selected='selected'</c:if> value="산업용품">산업용품</option>
														<option <c:if test="${(updatef[0].locname) == '핸드폰'}">selected='selected'</c:if> value="핸드폰">핸드폰</option>
														<option <c:if test="${(updatef[0].locname) == '현금'}">selected='selected'</c:if> value="현금">현금</option>
														<option <c:if test="${(updatef[0].locname) == '카드'}">selected='selected'</c:if> value="카드">카드</option>
														<option <c:if test="${(updatef[0].locname) == '노트북'}">selected='selected'</c:if> value="노트북">노트북</option>
														<option <c:if test="${(updatef[0].locname) == '악기'}">selected='selected'</c:if> value="악기">악기</option>
														<option <c:if test="${(updatef[0].locname) == '지갑'}">selected='selected'</c:if> value="지갑">지갑</option>
														<option <c:if test="${(updatef[0].locname) == '증명서'}">selected='selected'</c:if> value="증명서">증명서</option>
														<option <c:if test="${(updatef[0].locname) == '스포츠용품'}">selected='selected'</c:if> value="스포츠용품">스포츠용품</option>
														<option <c:if test="${(updatef[0].locname) == '전자기기'}">selected='selected'</c:if> value="전자기기">전자기기</option>
														<option <c:if test="${(updatef[0].locname) == '자동차'}">selected='selected'</c:if> value="자동차">자동차</option>
														<option <c:if test="${(updatef[0].locname) == '의류'}">selected='selected'</c:if> value="의류">의류</option>
														<option <c:if test="${(updatef[0].locname) == '기타'}">selected='selected'</c:if> value="기타">기타</option>
											      </select>
											</div>
											<label for='inputPlace'
												class='col-lg-2 col-form-label form-control-label' style="text-align:right">보상여부</label>
											<div class='col-lg-5'>
												<div class="select-box">
													<select name="logift" class="ui fluid dropdown" id="giftname">
											          	<option value="0">없음</option>
											          	<option value="1">있음</option>
											   	  	</select>
											   	</div>
											</div>
										</div>
										
										<div class='form-group row'>
											<label for='inputPnum'
												class='col-lg-2 col-form-label form-control-label'>내용</label>
											<div class='col-lg-10'>
												<textarea rows="2" class='form-control csisize fs-12' type='text' id='editCon'
													name='locon' value='${updatef[0].locon}' required=''></textarea>
											</div>
										</div>
										
<!-- 										<div id=fileup> -->
<!-- 											<input type="file" name="files" multiple> -->
<!-- 										</div> -->
																			
										</br>
										<div class='flex-w flex-m m-r-20 m-tb-5'>
											<div
												class='flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5'
												style='opacity: 0; pointer-events: none'></div>
											<button
												class='flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10'
												id='submit2' name='submit2' type='submit'>
												수정</button>
											&emsp;
											<div
												class='flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10'
												id='submit3' name='submit3' onclick="location.href='list.do'">
												취소</div>
										</div>
									</form>
						</div>
					</div>


				</div>
				
			</div>
		</div>
	</section>
	<!-- /////////////////////////////////////// 컨텐츠 종료  /////////////////////////////////////// -->
	<!-- *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* -->
	
	<!-- *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* -->
	<!-- ////////////////////////////////////// footer 시작 ////////////////////////////////////// -->

	<footer class="bg3 p-t-75 p-b-32">
		<div class="container">
			<div class="row">
			
				<div class="col-sm-6 col-lg-3 p-b-50">
						<h4 class="stext-301 cl0 p-b-30" style="font-size:100px">
							<img src="../images/003-w.png" >
						</h4>
	
					</div>
				
				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						CATEGORIES
					</h4>
					
						<ul>
							<li class="p-b-10">
								<a href="../gxsx/notice.do" class="stext-107 cl7 hov-cl1 trans-04">
									Notice
								</a>
							</li>
	
							<li class="p-b-10">
								<a href="../finditem/list.do?cp=1" class="stext-107 cl7 hov-cl1 trans-04">
									Finditem
								</a>
							</li>
	
							<li class="p-b-10">
								<a href="../lostitem/list.do?cp=1" class="stext-107 cl7 hov-cl1 trans-04">
									Lostitem
								</a>
							</li>	
						</ul> 
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						CONTACT US
					</h4>

					<p class="stext-107 cl7 size-201">
						<i class="fa fa-home"></i> 서울 마포구 백범로 23 구프라자 3층, 
						<br/>&nbsp;&nbsp;&nbsp; (지번)신수동 63-14 구프라자 3층
					</p>
					<p class="stext-107 cl7 size-201">
						<i class="fa fa-phone"></i> 02-707-1480
					</p>
					<p class="stext-107 cl7 size-201">
						<i class="fa fa-envelope"></i> javaoneteam@gmail.com
						
					</p>

					<div class="p-t-27">
						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-facebook"></i>
						</a>

						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-instagram"></i>
						</a>

						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-pinterest-p"></i>
						</a>
					</div>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						BUSINESS HOURS
					</h4>

					<p class="stext-107 cl7 size-201">
						<i class="fa fa-clock-o"></i> <span class="day">Weekdays : </span>
						<span>9am to 8pm</span>
					</p>
					<p class="stext-107 cl7 size-201">
						<i class="fa fa-clock-o"></i> <span class="day">Saturday &nbsp; : </span>
						<span>9am to 2pm</span>
					</p>
					<p class="stext-107 cl7 size-201">
						<i class="fa fa-clock-o"></i> <span class="day">Sunday &nbsp; &nbsp; : </span>
						<span>Closed</span>
					</p>
				</div>
			</div>

			<p class="stext-107 cl6 txt-center">
			<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | by Sansillyung <i class="fa fa-heart-o" aria-hidden="true"></i> 
			<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->

				</p>
			</div>
		</div>
	</footer>
	
	<!-- ////////////////////////////////////// footer 종료 ////////////////////////////////////// -->	
	<!-- *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* -->


	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>
	
<!--===============================================================================================-->	
	<script src="../vendor/coza/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/coza/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/coza/bootstrap/js/popper.js"></script>
	<script src="../vendor/coza/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/coza/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="../vendor/coza/daterangepicker/moment.min.js"></script>
	<script src="../vendor/coza/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/coza/slick/slick.min.js"></script>
	<script src="../js/coza/slick-custom.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/coza/parallax100/parallax100.js"></script>
	<script>
        $('.parallax100').parallax100();
	</script>
<!--===============================================================================================-->
	<script src="../vendor/coza/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<script>
		$('.gallery-lb').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		        	enabled:true
		        },
		        mainClass: 'mfp-fade'
		    });
		});
	</script>
<!--===============================================================================================-->
	<script src="../vendor/coza/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/coza/sweetalert/sweetalert.min.js"></script>
	<script>
		$('.js-addwish-b2').on('click', function(e){
			e.preventDefault();
		});

		$('.js-addwish-b2').each(function(){
			var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");

				$(this).addClass('js-addedwish-b2');
				$(this).off('click');
			});
		});

		$('.js-addwish-detail').each(function(){
			var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

			$(this).on('click', function(){
				swal(nameProduct, "is added to wishlist !", "success");

				$(this).addClass('js-addedwish-detail');
				$(this).off('click');
			});
		});

		/*---------------------------------------------*/

		$('.js-addcart-detail').each(function(){
			var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
			$(this).on('click', function(){
				swal(nameProduct, "is added to cart !", "success");
			});
		});
	</script>
<!--===============================================================================================-->
	<script src="../vendor/coza/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="../js/coza/main.js"></script>
	
	<!-- 자바스크립트  -->
	<script src="../js/tempjs/FiComments.js"></script>

</body>
</html>