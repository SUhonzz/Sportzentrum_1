from tinydb import TinyDB, Query
from serializer import serializer


def datetimeformatter (datetime):
    return datetime.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")

def add_reservation_to_db(reservation):
    db = TinyDB('database.json', storage=serializer)
    reservations = db.table('reservations')
    reservations.insert({'name': reservation.name, 'start': reservation.start, 'end': reservation.end, 'hash': reservation.resourceID})
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