/**
 * 
 */
const paymentStart =()=>{
    console.log("payment started");
    let amount =$("#payment_field").val();
    let student_id=document.getElementById('mySt_id').value;
    let st_course_id=document.getElementById('mySt_course_id').value;
    console.log(amount);
    if(amount == '' || amount == null)
    {
        swal("Failed!!", "Amount is required..", "error");   
             return;
    }
    $.ajax({
        url: 'http://localhost:8081/FEES_MANAGE/OrderCreation',
        data:JSON.stringify({amount:amount,info:'order_request'}),
        contentType:'application/json',
        type:'POST',
        dataType:'json',
        success:function(response){
            console.log(response);
            if(response.status== "created")
            {
                let option={
                    key: "rzp_test_tN00KemE4lMnax", // Enter the Key ID generated from the Dashboard
                    amount:response.amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
                    currency: "INR",
                    name: "Raman Fee Management System",
                    callback_url:"http://localhost:8081/FEES_MANAGE/studentHome.jsp",
                    description: "Kharcha Kar Apne course ka! ",
                    image: "https://5.imimg.com/data5/SELLER/Default/2022/3/FR/RK/CU/32094369/fee-management-system-1000x1000.png",
                    order_id: response.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
                    handler: function (response){
                        console.log(response.razorpay_payment_id);
                        console.log(response.razorpay_order_id);
                        console.log(response.razorpay_signature);
                        console.log("payment Successful");
                    updatePaymentOnServer(response.razorpay_payment_id,amount,student_id,st_course_id);
                        swal("Good job!", "Congrats!! payment Successful...", "success");  

                },
                  prefill: {
                 name: "Raman Grewal",
                 email: "grewalraman130@gmail.com",
                 contact: "7027367103"
                },
                notes: {
                    address: "Office Fee Management"
                },
                theme: {
                    color: "#3399cc"
                },
                    page: "https://rzp.io/l/HPXxhIle"
            
            };
            let rzp=new Razorpay(option);
            rzp.on('payment.failed', function (response){
                console.log(response.error.code);
                console.log(response.error.description);
                console.log(response.error.source);
                console.log(response.error.step);
                console.log(response.error.reason);
                console.log(response.error.metadata.order_id);
                console.log(response.error.metadata.payment_id);
                swal("Failed!!", "opps!! payment Failed", "error");

        });
            rzp.open();
        }
    },
        error:function(error){
            console.log(error);
            alert("Something went wrong!");

        }
    
    })
};

function updatePaymentOnServer(payment_id,Yamount,st_id,st_co_id)
{
    $.ajax({
        url: 'http://localhost:8081/FEES_MANAGE/PaymentSave',
        data:JSON.stringify({payment_id:payment_id,Yamount:Yamount,
        st_id:st_id,st_co_id:st_co_id}),
        contentType:'application/json',
        type:'POST',
        dataType:'json',
    success: function(response) {
    console.log(response);
    swal("Good job!", "Congrats!! payment Successful...", "success")
        // Redirect to preferred URL
        window.location.replace("http://localhost:8081/FEES_MANAGE/studentHome.jsp");
  
    
},

        error:function(error){
            console.log(error);
            swal("Failed!!", "opps!! payment successful but failed to save in database", "error");

        }
       
    }); 


}