<html>
<!DOCTYPE body PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<div
	style="border-radius: 25px; background: #e6f7ff; padding: 5px; margin-top: 5px;">
	<span>
		<form action="/Reserve" method="POST">
			<div style="border: 1px solid #e6f7ff; border-radius: 5px; margin: 5px 5px 5px 5px; padding: 5px 5px 5px 5px;">
				<span style="line-height:1.5"> 
				Baggage Checkout 
				<select name="PassengerBaggage" style="width: 97px" > 
						<option value="var">VAR</option>
						<option value="yok">YOK</option>
				</select>
				</span>
			</div>
			<div style="border: 1px solid #e6f7ff; border-radius: 5px; margin: 5px 5px 5px 5px; padding: 5px 5px 5px 5px;">
				<span style="line-height:1.5"> Possible Boarding Point
				<input name="PossibleBoardingPoint"
					type="text" size="12" />
				</span>
			</div>
			<div style="margin-bottom: 10px; padding-left: 10px; margin-top: 10px;">
				<button type="submit" class="btn btn-success btn-sm">submit</button>
			</div>
		</form>
	</span>
</div>
</body>
</html>
<!-- border: 1px solid black; border-radius: 5px;  -->