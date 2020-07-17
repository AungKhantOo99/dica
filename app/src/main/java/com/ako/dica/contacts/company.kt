package com.ako.dica.contacts

class company {
    var Cname:String?=null
    var Caddress:String?=null
    var Cfph:String?=null
    var Csph:String?=null
    var Cfemail:String?=null
    var Csemail:String?=null
    var CLat:Double?=null
    var CLong:Double?=null
    constructor(Cname:String,
                Caddress:String,
                Cfph:String,
                Csph:String,
                Cfemail:String,
                Csemail:String,
                CLat:Double,
                CLong:Double)
    {
        this.Cname=Cname
        this.Caddress=Caddress
        this.Cfph=Cfph
        this.Csph=Csph
        this.Cfemail=Cfemail
        this.Csemail=Csemail
        this.CLat=CLat
        this.CLong=CLong
    }
}