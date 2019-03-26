import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { ITowerTemp, defaultValue } from 'app/shared/model/tower-temp.model';

export const ACTION_TYPES = {
  FETCH_TOWERTEMP_LIST: 'towerTemp/FETCH_TOWERTEMP_LIST',
  FETCH_TOWERTEMP: 'towerTemp/FETCH_TOWERTEMP',
  CREATE_TOWERTEMP: 'towerTemp/CREATE_TOWERTEMP',
  UPDATE_TOWERTEMP: 'towerTemp/UPDATE_TOWERTEMP',
  DELETE_TOWERTEMP: 'towerTemp/DELETE_TOWERTEMP',
  RESET: 'towerTemp/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<ITowerTemp>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type TowerTempState = Readonly<typeof initialState>;

// Reducer

export default (state: TowerTempState = initialState, action): TowerTempState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_TOWERTEMP_LIST):
    case REQUEST(ACTION_TYPES.FETCH_TOWERTEMP):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_TOWERTEMP):
    case REQUEST(ACTION_TYPES.UPDATE_TOWERTEMP):
    case REQUEST(ACTION_TYPES.DELETE_TOWERTEMP):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_TOWERTEMP_LIST):
    case FAILURE(ACTION_TYPES.FETCH_TOWERTEMP):
    case FAILURE(ACTION_TYPES.CREATE_TOWERTEMP):
    case FAILURE(ACTION_TYPES.UPDATE_TOWERTEMP):
    case FAILURE(ACTION_TYPES.DELETE_TOWERTEMP):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_TOWERTEMP_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_TOWERTEMP):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_TOWERTEMP):
    case SUCCESS(ACTION_TYPES.UPDATE_TOWERTEMP):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_TOWERTEMP):
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

const apiUrl = 'api/tower-temps';

// Actions

export const getEntities: ICrudGetAllAction<ITowerTemp> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_TOWERTEMP_LIST,
  payload: axios.get<ITowerTemp>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<ITowerTemp> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_TOWERTEMP,
    payload: axios.get<ITowerTemp>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<ITowerTemp> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_TOWERTEMP,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<ITowerTemp> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_TOWERTEMP,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<ITowerTemp> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_TOWERTEMP,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
