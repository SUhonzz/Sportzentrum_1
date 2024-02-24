import datetime as dt
import pandas as pd
from datetime import datetime as dt, timedelta
from tinydb import TinyDB, Query
from serializer import serializer
import os
import numpy as np
import hashlib



class reservation():
    def __init__(self, name:str, start:dt, end:dt):
        self.name = name
        self.start = start
        self.end = end
        #hashing the reservation to get a unique ID
        starttimestring = start.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        endtimestring = end.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        string_to_hash = name + starttimestring + endtimestring
        string_bytes = string_to_hash.encode('utf-8')
        hash_object = hashlib.sha256()
        hash_object.update(string_bytes)
        
        resourceID = hash_object.hexdigest()

    def __str__(self):
        return f"Name: {self.name}\nEmail: {self.email}\nPhone: {self.phone}\nDate: {self.date}\nTime: {self.time}\nParty: {self.party}\nMessage: {self.message}"

    
    
    
        