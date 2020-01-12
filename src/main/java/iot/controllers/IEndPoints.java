package main.java.iot.controllers;

public interface IEndPoints {

    public final static String SENSOR_CONTROLLER = "/sensors";
    public final static String TYPE_CONTROLLER = "/sensors-type";
    public final static String SENSOR_GET_BY_ID = "/sensor-id";
    public final static String SENSOR_GET_BY_TYPE = "/sensor-type";
    public final static String SENSOR_GET_TIMESTAMP = "/timestamp";
    public final static String SENSOR_GET_ALL_ID = "/sensor-all";
    public final static String TYPE_ADD_SENSOR = "/sensor-type";
    public final static String TYPE_GET_SENSOR = "/sensor-type";
    public final static String TYPE_REMOVE_SENSOR = "/sensor-type";
    public final static String TYPE_UPD_NAME = "/sensor-name";
    public final static String TYPE_UPD_LOC = "/sensor-loc";
    public final static String TYPE_UPD_MAPPER = "/sensor-mapper";
    public final static String TYPE_UPD_CONTACTS = "/sensor-contacts";
    public final static String TYPE_UPD_VALUES = "/sensor-values";
    public final static String ENUM_TYPES = "/sensor-types";
    public final static String ENUM_ACTIONS = "/sensor-actions";
    public final static String ENUM_OPERATIONS = "/sensor-operations";
}
