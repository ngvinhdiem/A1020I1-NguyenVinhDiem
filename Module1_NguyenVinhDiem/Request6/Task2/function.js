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

function  validateIdNumber(number) {
    const tes1 = /^([1-9])\d{8}$/;
    const tes2 = /^([1-9])\d{11}$/;
    return !(tes1.test(String(number)) === false && tes2.test(String(number)) === false);
}

function  validatePhone(number) {
    const tes3 = /^([0-9])\d{8}$/;
    const tes4 = /^([0-9])\d{9}$/;
    return !(tes3.test(String(number)) === false && tes4.test(String(number)) === false);
}

function validateDate(date) {
    const er= /^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$/;
    return er.test(String(date));
}

function validateEmail(email) {
    const re = /\S+@\S+\.\S+/;
    //          /([a-zA-Z])+@+(([a-zA-Z])+\.)+([com]{3})+$/;
    return re.test(String(email).toLowerCase());
}

function changeAddress(address) {
    while (true) {
        if (address.length !== 0) {
            let subArray = new Array(address.length);
            for (let i = 0; i < subArray.length; i++) {
                subArray[i] = address[i];
            }
            let g = (subArray.join('')).toUpperCase();
            let h = (subArray.join('')).toLowerCase();
            for (let i = 0; i < subArray.length; i++) {
                if (subArray[0] !== ' ') subArray[0] = g[0];
                if (subArray[i] === ' ' && subArray[i + 1] !== ' ') subArray[i + 1] = g[i + 1];
            }
            for (let i = 0; i < subArray.length - 1; i++) {
                if (subArray[i] !== ' ' && subArray[i + 1] !== ' ') subArray[i + 1] = h[i + 1];
            }
            for (let i = 0; i < subArray.length; i++) {
                if (subArray[i] === ' ') {
                    subArray.splice(i, 1);
                    i--;
                } else break;
            }
            for (let i = 0; i < subArray.length; i++) {
                if (subArray[i] === ' ' && subArray[i + 1] === ' ') {
                    subArray.splice(i, 1);
                    i--;
                }
            }
            address = subArray.join('');
            break;
        } else {
            alert("Mời nhập lại địa chỉ: ");
            address = prompt("Địa chỉ: ");
        }
    }
}

function changeLocation(customerType) {
    {
        let subArray = new Array(customerType.length);
        let biendem = 0;
        for (let i = 0; i < subArray.length; i++) {
            subArray[i] = customerType[i];
        }
        let g = (subArray.join('')).toUpperCase();
        let h = (subArray.join('')).toLowerCase();
        for (let i = 0; i < subArray.length; i++) {
            if (subArray[i] !== ' ') subArray[i] = g[i];
        }
        for (let i = 0; i < subArray.length; i++) {
            if (subArray[i] !== ' ') biendem++;
            if (biendem >= 2) subArray[i] = h[i];
        }
        for (let i = 0; i < subArray.length; i++) {
            if (subArray[i] === ' ') {
                subArray.splice(i, 1);
                i--;
            }
        }
        customerType = subArray.join('');
    }
    while (true) {
        if (customerType === 'Manager' || customerType === 'Sale' || customerType === 'Marketing' )
            break;
        else {
            alert("Mời nhập lại!");
            customerType = prompt("Vị trí làm việc (Manager, Sale, Marketing): ");
        }
    }
}

