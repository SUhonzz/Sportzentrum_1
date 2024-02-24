import streamlit as st
import pandas as pd
import numpy as np
import tinydb as db
from datetime import datetime as dt, timedelta
from streamlit_calendar import calendar
from functions import *
from classes import *

reservations = []
new_reservation = reservation("Test",dt.now(),dt.now()+timedelta(hours=1))
reservations.append(new_reservation)
#add_reservation_to_db(new_reservation)


st.set_page_config(page_title="Reservierungen Tennisplätze", page_icon="tennis", layout="wide")
st.write("# Reservierungen Tennisplätze")


now = dt.now() #jetzt
now_formatted_time = datetimeformatter(now)
time1 = datetimeformatter(now+timedelta(days=1))

#sterprint(now_formatted_time)
calendar_options = {
    "editable": "true",
    "height": "auto",
    "ResourcesSize": "10px",
        "selectable": "true",
    "headerToolbar": {
        "left": "today prev,next",
        "center": "title",
        "right": "resourceTimelineDay,resourceTimelineWeek,resourceTimelineMonth",
    },
    "slotMinTime": "09:00:00",
    "slotMaxTime": "24:00:00",
    "initialView": "resourceTimelineDay",
    "resourceGroupField": "Plätze",
    "resources": [
        {"id": "P1", "Plätze": "Baloon", "title": "Platz 1"},
        {"id": "P2", "Plätze": "Baloon", "title": "Platz 2"},
        {"id": "P3", "Plätze": "Freiluft", "title": "Platz 3"},
        {"id": "P4", "Plätze": "Freiluft", "title": "Platz 4"},
        
    ],
}

calendar_events = [
    {
        "title": "Res1",
        "start": "2024-02-24T07:30:00",
        "end": "2024-02-24T10:30:00",
        "resourceId": "P1",
    },
    {
        "title": "Event 2",
        "start": "2023-07-31T07:30:00",
        "end": "2023-07-31T10:30:00",
        "resourceId": "P3",
    },
    {
        "title": "Event 3",
        "start": "2023-07-31T10:40:00",
        "end": "2023-07-31T12:30:00",
        "resourceId": "P4",
    }
]
custom_css="""
    .fc-event-past {
        opacity: 0.8;
    }
    .fc-event-time {
        font-style: italic;
    }
    .fc-event-title {
        font-weight: 700;
    }
    .fc-toolbar-title {
        font-size: 2rem;
    }
"""
#max_time = today + dt.timedelta(days=13) #in 14 tragen
#min_time = today.dt.time.hour-dt.time.minute-dt.time.second #heute 00:00:00


col1, col2 = st.columns([1, 0.2])
with col1:
    st.header("Reservierungen")


    
    calendar = calendar(calendar_events, options=calendar_options, custom_css=custom_css)

    col1_1, col1_2,col1_3 = st.columns([1,0.3,1])
    
    with col1_1:
        st.header("Neue Reservierung")
        with st.container(border = True):
            
            st.text_input("Name",key = "name_neu")
            st.date_input("Datum",key = "datum_neu")
            st.time_input("Von",key = "uhrzeitvon_neu")
            st.time_input("Bis",key = "uhrzeutbis_neu")
            st.selectbox("Platz",["Platz 1","Platz 2","Platz 3","Platz 4"],key = "platz_neu")
            st.button("Reservierung hinzufügen",key = "reservierung_neu")
        


    with col1_3:
        st.header("Reservierung bearbeiten")
        with st.container(border=True):
            
            st.text_input("Name",key = "name_bearbeiten")
            st.date_input("Datum",key = "datum_bearbeiten")
            st.time_input("Von",key = "uhrzeitvon_bearbeiten")
            st.time_input("Bis",key = "uhrzeitbis_bearbeiten")
            st.selectbox("Platz",["Platz 1","Platz 2","Platz 3","Platz 4"],key = "platz_bearbeiten")
            st.button("Reservierung bearbeiten",key = "reservierung_bearbeiten")


with col2:  
    with st.container(border=True):
        st.header("Anfragen")
