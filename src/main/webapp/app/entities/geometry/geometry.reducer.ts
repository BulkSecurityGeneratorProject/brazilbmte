import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IGeometry, defaultValue } from 'app/shared/model/geometry.model';

export const ACTION_TYPES = {
  FETCH_GEOMETRY_LIST: 'geometry/FETCH_GEOMETRY_LIST',
  FETCH_GEOMETRY: 'geometry/FETCH_GEOMETRY',
  CREATE_GEOMETRY: 'geometry/CREATE_GEOMETRY',
  UPDATE_GEOMETRY: 'geometry/UPDATE_GEOMETRY',
  DELETE_GEOMETRY: 'geometry/DELETE_GEOMETRY',
  RESET: 'geometry/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IGeometry>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type GeometryState = Readonly<typeof initialState>;

// Reducer

export default (state: GeometryState = initialState, action): GeometryState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_GEOMETRY_LIST):
    case REQUEST(ACTION_TYPES.FETCH_GEOMETRY):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_GEOMETRY):
    case REQUEST(ACTION_TYPES.UPDATE_GEOMETRY):
    case REQUEST(ACTION_TYPES.DELETE_GEOMETRY):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_GEOMETRY_LIST):
    case FAILURE(ACTION_TYPES.FETCH_GEOMETRY):
    case FAILURE(ACTION_TYPES.CREATE_GEOMETRY):
    case FAILURE(ACTION_TYPES.UPDATE_GEOMETRY):
    case FAILURE(ACTION_TYPES.DELETE_GEOMETRY):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_GEOMETRY_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_GEOMETRY):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_GEOMETRY):
    case SUCCESS(ACTION_TYPES.UPDATE_GEOMETRY):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_GEOMETRY):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/geometries';

// Actions

export const getEntities: ICrudGetAllAction<IGeometry> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_GEOMETRY_LIST,
  payload: axios.get<IGeometry>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<IGeometry> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_GEOMETRY,
    payload: axios.get<IGeometry>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IGeometry> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_GEOMETRY,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IGeometry> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_GEOMETRY,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IGeometry> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_GEOMETRY,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
