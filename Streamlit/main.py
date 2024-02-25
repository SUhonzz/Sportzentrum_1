import streamlit as st
import pandas as pd
import numpy as np
import tinydb as db
from datetime import datetime as dt, timedelta
from streamlit_calendar import calendar
from functions import *
from classes import *
from streamlit_modal import Modal

#DBtest

testtime = dt.today()-timedelta(hours=dt.today().hour,minutes=dt.today().minute,seconds=dt.today().second,microseconds=dt.today().microsecond)+timedelta(hours=9) #heute 00:09:00 

print(testtime)

new_reservation = reservation("Test",testtime,testtime+timedelta(hours=1),1)

if check_hash_in_db(new_reservation.hash) == False:
    add_reservation_to_db(new_reservation)


#DBTestEnd

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

tab1, tab2 = st.tabs(["Reservierungen", "Anfragen"])
with tab1:

    st.header("Reservierungen")


    
    calendar = calendar(calendar_events, options=calendar_options, custom_css=custom_css)

    col1_1, col1_2,col1_3 = st.columns([1,0.3,1])
    
    with col1_1:
        st.header("Neue Reservierung")
        with st.container(border = True):
            
            name_input = st.text_input("Name",key = "name_neu")
            date_input = st.date_input("Datum",key = "datum_neu")
            timestartinput = st.time_input("Von",key = "uhrzeitvon_neu")
            timeendinout = st.time_input("Bis",key = "uhrzeutbis_neu")
            courtinput = st.selectbox("Platz",["Platz 1","Platz 2","Platz 3","Platz 4"],key = "platz_neu")
            if courtinput == "Platz 1":
                courtint = 1
            elif courtinput == "Platz 2":
                courtint = 2
            elif courtinput == "Platz 3":
                courtint = 3
            elif courtinput == "Platz 4":
                courtint = 4
            if st.button("Reservierung hinzufügen",key = "reservierung_neu"):
                if name_input == "":
                    st.error("Name fehlt")
                else:
                    st.success("Reservierung hinzugefügt")
                    new_reservation = reservation(name_input,dt.combine(date_input,timestartinput),dt.combine(date_input,timeendinout),courtint)
                    if check_hash_in_db(new_reservation.hash) == False:
                        add_reservation_to_db(new_reservation)
                    else:
                        st.error("Reservierung bereits vorhanden")
        


    with col1_3:
        st.header("Reservierung bearbeiten")
        with st.container(border=True):
            
            st.text_input("Name",key = "name_bearbeiten")
            st.date_input("Datum",key = "datum_bearbeiten")
            st.time_input("Von",key = "uhrzeitvon_bearbeiten")
            st.time_input("Bis",key = "uhrzeitbis_bearbeiten")
            st.selectbox("Platz",["Platz 1","Platz 2","Platz 3","Platz 4"],key = "platz_bearbeiten")
            st.button("Reservierung bearbeiten",key = "reservierung_bearbeiten")
            if st.button("Reservierung löschen",key = "reservierung_löschen"):
                st.error("Do you really, really, wanna do this?")
                if st.button("Yes I'm ready to rumble"):
                    st.write("Reservierung gelöscht")


with tab2:  
    st.header("Anfragen")
    st.header("")

    with st.container(border=True):

        for j in range(0,5):
            col1, col2, col3, col4,col5  = st.columns(5)
            with col1:
                st.write("Name")
            with col2:
                st.write("Datum")
            with col3:
                st.write("Zeit")
                with col4:
                    st.write("Platz")
            with col5:
                col1_1, col1_2, col1_3 = st.columns([1,1,1])
                with col1_1:
                    st.button("Annehmen",key = f"annehmen{j}")
                with col1_2:
                    st.button("Verschieben", key = f"verschieben{j}")
                with col1_3:
                    st.button("Ablehnen", key = f"ablehnen{j}")

                    
                
        
