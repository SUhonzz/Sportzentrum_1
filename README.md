Hashing:
SHA256 with hexdigest


        #hashing the reservation to get a unique ID
        __starttimestring = start.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        __timestampstring = self.timestamp.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        __string_to_hash = name + __starttimestring + __timestampstring + f"{court}"
        __string_bytes = __string_to_hash.encode('utf-8')
        __hash_object = hashlib.sha256()
        __hash_object.update(__string_bytes)
        
        self.hash = __hash_object.hexdigest()

        


        hash = hash_object.hexdigest()

Class Reservation
    Name:       str
    Date:       Datetime
    Starttime:  Datetime
    Endtime:    Datetime
    Hash        str
    Court       int
    timestamp   dt

DB Structure: 
    table reservations:     Reservation Object
    table requests:         Reservation Object

removed timestamp for debug
added reservation to db writing
still to controll wether court is blocked on this particular instance
calendar events to do
calendar click on reservations form fillout
layouting?
read db for requests to do