function changeString(name){
    name=name.trim();
    name=name.toLowerCase();
    let array=[];
    array=name.split(' ');
    let result=""; let word="";
    for (let i=0;i<array.length;i++) {
        if (array[i]!=="") {
            word=array[i].charAt(0).toUpperCase()+array[i].substring(1);
            result+=word+" ";
        }
    }
    result=result.trim();
    return result;
}

function  validatePhone(number) {
    const tes4 = /^([0])\d{9}$/;
    return tes4.test(String(number));
}

function validateEmail(email) {
    // const re = /\S+@\S+\.\S+/;
    const re = /([a-zA-Z-0-9])+@+(([a-zA-Z])+\.)+([a-zA-Z])+$/;
    return re.test(String(email).toLowerCase());
}

