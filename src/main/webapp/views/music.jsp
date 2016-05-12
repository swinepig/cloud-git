<%@ include file="../common/include_tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>music player</title>
<link rel="stylesheet" type="text/css" media="screen" href="<s:url value='/resources/css/jplayer/style.css'/>" />
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/jplayer/reset.css'/>" />
    
<script type="text/javascript" src="<s:url value='/resources/js/jplayer/jquery-1.8.3.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/resources/js/jplayer/jplayer.playlist.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/resources/js/jplayer/jquery.jplayer.min.js'/>"></script>
<script type="text/javascript">
$(function(){

	  var cssSelector = {
	    jPlayer: "#jquery_jplayer",
	    cssSelectorAncestor:".music-player"
	  };
	  
	  var options = {
	     playlistOptions: {
	     autoPlay: true
	  	},
	    swfPath: "Jplayer.swf",
	    solution: 'html, flash',
	    supplied: "ogv, m4v, oga, mp3"
	  };

	  $.ajax({
	        url: 'music',
	        contentType : 'application/json',
	        type: 'get',
	        dataType: "text",
	        success: function (responseText) {
	        console.log(responseText);
		  	new jPlayerPlaylist(cssSelector, eval(responseText), options);
	        }
	    });
	});
</script>
</head>
<body class="keBody">
<div class="kePublic">
<!--效果html开始-->
  <div class="music-player">
  <div style="background-image: url(../resources/images/jplayer/yqB0erk.jpg);" class="album"></div>
  <div class="info">
    <div class="left">
      <a href="javascript:;" class="icon-shuffle"></a>
      <a href="javascript:;" class="icon-heart"></a>
    </div>
    <div class="center">
    <div class="jp-playlist">
      <ul>
        <li></li>
      </ul>
    </div>
    </div>
    <div class="right">
      <a href="javascript:;" class="icon-repeat jp-repeat"></a>
      <a href="javascript:;" class="icon-share"></a>
    </div>

    <div class="progress jp-seek-bar">
      <span class="jp-play-bar" style="width: 0%"></span>
    </div>
  </div>

  <div class="controls">
    <div class="current jp-current-time">00:00</div>
    <div class="play-controls">
      <a href="javascript:;" class="icon-previous jp-previous" title="previous"></a>
      <a href="javascript:;" class="icon-play jp-play" title="play"></a>
      <a href="javascript:;" class="icon-pause jp-pause" title="pause"></a>
      <a href="javascript:;" class="icon-next jp-next" title="next"></a>
    </div>
    <div class="volume-level jp-volume-bar">
      <span class="jp-volume-bar-value" style="width: 0%"></span>
      <a href="javascript:;" class="icon-volume-up jp-volume-max" title="max volume"></a>
      <a href="javascript:;" class="icon-volume-down jp-mute" title="mute"></a>
    </div>
  </div>
  <div id="jquery_jplayer" class="jp-jplayer"></div>
</div>
<!--效果html结束-->
<div class="clear"></div>
</div>
</body>
</html>