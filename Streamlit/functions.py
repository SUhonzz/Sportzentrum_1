from tinydb import TinyDB, Query
from serializer import serializer
from classes import reservation


def datetimeformatter (datetime):
    return datetime.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")

def add_reservation_to_db(reservation):
    db = TinyDB('database.json', storage=serializer)
    reservations = db.table('reservations')
    reservations.insert({'name': reservation.name, 'start': reservation.start, 'end': reservation.end, 'hash': reservation.hash, 'court': reservation.court	})
    db.close()
    return

def get_reservations_from_db():
    db = TinyDB('database.json', storage=serializer)
    reservations = db.table('reservations')
    reservations = reservations.all()
    db.close()
    return reservations

def delete_reservation_from_db(reservation):
    db = TinyDB('database.json', storage=serializer)
    reservations = db.table('reservations')
    reservations.remove(Query().hash == reservation.name)
    db.close()
    return

def check_hash_in_db(hash):
    db = TinyDB('database.json', storage=serializer)
    reservations = db.table('reservations')
    result = reservations.search(Query().hash == hash)
    db.close()
    if len(result) > 0:
        print("Hash already in DB")
        return True
    else:
        return False