<jsp:include page="../header.jsp"/>
<title>AIDR - Interactive View/Download</title>
</head>
<body class="mainbody">
  <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/taggui/interactive-view-download/Application.js"></script>

  <script type="text/javascript">
      CRISIS_ID = ${crisisId};
      COLLECTION_ID = ${collectionId};
      CRISIS_CODE = "${code}";
      CRISIS_NAME = "${crisisName}";
      USER_NAME = "${userName}";
      ITEM_PLURAL = "${item_plural}";
  </script>

</body>
</html>