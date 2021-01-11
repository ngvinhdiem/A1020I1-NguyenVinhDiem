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

function validateDate(date) {
    const er= /^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$/;
    return er.test(String(date));
}

function validateEmail(email) {
    // const re = /\S+@\S+\.\S+/;
    const re = /([a-zA-Z-0-9])+@+(([a-zA-Z])+\.)+([a-zA-Z])+$/;
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

function changeCustomerType(customerType) {
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
        if (customerType === 'Diamond' || customerType === 'Platinum' || customerType === 'Gold' || customerType === 'Silver' || customerType === 'Member')
            break;
        else {
            alert("Mời nhập lại loại Customer (Diamond, Platinum, Gold, Silver, Member): ");
            customerType = prompt("Loại Customer (Diamond, Platinum, Gold, Silver, Member): ");
        }
    }
}

function changeDiscount(discount) {
    while (true) {

        if (discount > 0 && !isNaN(discount) && discount <= 100) break;
        else {
            alert("Mời nhập lại giảm giá (%): ");
            discount = parseInt(prompt("Giảm giá (%): "));
        }
    }
}

function changeExtra(extra) {
    while (true) {

        if (extra > 0 && !isNaN(extra)) break;
        else {
            alert("Mời nhập lại số lượng đi kèm: ");
            numEx = '';
            extra = parseInt(prompt("Số lượng đi kèm: "));
        }
    }
}

function changeRentDays(rentDays) {
    while (true) {
        if (rentDays > 0 && !isNaN(rentDays)) break;
        else {
            alert("Mời nhập lại số ngày thuê: ");
            rentDays = parseInt(prompt("Số ngày thuê: "));
        }
    }
}

function changeRoomType(roomType) {
    {let subArray= new Array(roomType.length); let biendem =0;
        for (let i=0;i<subArray.length;i++) { subArray[i]=roomType[i]; }
        let g=(subArray.join('')).toUpperCase(); let h=(subArray.join('')).toLowerCase();
        for (let i=0;i<subArray.length;i++) { if (subArray[i]!==' ') subArray[i]=g[i];}
        for (let i=0;i<subArray.length;i++) { if (subArray[i]!==' ') biendem++; if (biendem>=2) subArray[i]=h[i]; }
        for (let i=0;i<subArray.length;i++) { if (subArray[i]===' ') {subArray.splice(i,1); i--;}}
        roomType=subArray.join('');}
    while (true) {
        if (roomType === 'Vip' || roomType === 'Business' || roomType === 'Normal' )
            break;
        else {
            alert("Mời nhập lại loại phòng thuê (Vip, Business,  Normal): ");
            customerType = prompt("Loại phòng thuê (Vip, Business,  Normal): ");
        }
    }
}

function changeServiceType(serviceType) {
    {let subArray= new Array(serviceType.length); let biendem =0;
        for (let i=0;i<subArray.length;i++) { subArray[i]=serviceType[i]; }
        let g=(subArray.join('')).toUpperCase(); let h=(subArray.join('')).toLowerCase();
        for (let i=0;i<subArray.length;i++) { if (subArray[i]!==' ') subArray[i]=g[i];}
        for (let i=0;i<subArray.length;i++) { if (subArray[i]!==' ') biendem++; if (biendem>=2) subArray[i]=h[i]; }
        for (let i=0;i<subArray.length;i++) { if (subArray[i]===' ') {subArray.splice(i,1); i--;}}
        serviceType=subArray.join('');}
    while (true) {
        if (serviceType === 'Villa' || serviceType === 'House' || serviceType === 'Room' )
            break;
        else {
            alert("Mời nhập lại loại dịch vụ (Villa, House, Room): ");
            serviceType = prompt("Loại dịch vụ (Villa, House, Room): ");
        }
    }
}