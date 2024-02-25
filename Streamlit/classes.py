import datetime as dt
import pandas as pd
from datetime import datetime as dt, timedelta
from tinydb import TinyDB, Query
from serializer import serializer
import os
import numpy as np
import hashlib



class reservation():
    def __init__(self, name:str, start:dt, end:dt, court:int):
        self.name = name
        self.start = start
        self.end = end
        self.court = court
        self.date = start.strftime("%Y-%m-%d")
        self.timestamp = dt.now()

        '''
        #Hashing the reservation to get a unique ID
        ##Parameters
        name: str - name of the person who reserves the court
        start: datetime - start time of the reservation
        end: datetime - end time of the reservation
        court: int - number of the court
        date - date of the reservation -self generated
        hash - unique hash of the reservation - self generated
        timestamp - timestamp of the reservation - self generated
        
        '''

        #hashing the reservation to get a unique ID
        __starttimestring = start.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        __timestampstring = self.timestamp.strftime("%Y-%m-%d" +"T" + "%H:%M:%S")
        __string_to_hash = name + __starttimestring + f"{court}" #+__timestampstring
        __string_bytes = __string_to_hash.encode('utf-8')
        __hash_object = hashlib.sha256()
        __hash_object.update(__string_bytes)
        
        self.hash = __hash_object.hexdigest()



    def __str__(self):
       return f"Name: {self.name}, Start: {self.start}, End: {self.end}, Court: {self.court}, Hash: {self.hash}"
    


    
    
    
        