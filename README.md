Hashing:
SHA256 with hexdigest


        starttimestring = start.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        endtimestring = end.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        string_to_hash = name + starttimestring + endtimestring
        string_bytes = string_to_hash.encode('utf-8')
        hash_object = hashlib.sha256()
        hash_object.update(string_bytes)
        #still to rework


        hash = hash_object.hexdigest()

Class Reservation
    Name:       str
    Date:       Datetime
    Starttime:  Datetime
    Endtime:    Datetime
    Hash        str
    Court       int

DB Structure: 
    table reservations:     Reservation Object
    table requests:         Reservation Object