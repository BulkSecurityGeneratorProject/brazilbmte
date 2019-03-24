import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IOverheadLine, defaultValue } from 'app/shared/model/overhead-line.model';

export const ACTION_TYPES = {
  FETCH_OVERHEADLINE_LIST: 'overheadLine/FETCH_OVERHEADLINE_LIST',
  FETCH_OVERHEADLINE: 'overheadLine/FETCH_OVERHEADLINE',
  CREATE_OVERHEADLINE: 'overheadLine/CREATE_OVERHEADLINE',
  UPDATE_OVERHEADLINE: 'overheadLine/UPDATE_OVERHEADLINE',
  DELETE_OVERHEADLINE: 'overheadLine/DELETE_OVERHEADLINE',
  RESET: 'overheadLine/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IOverheadLine>,
  entity: defaultValue,
  updating: false,
  updateSuccess: false
};

export type OverheadLineState = Readonly<typeof initialState>;

// Reducer

export default (state: OverheadLineState = initialState, action): OverheadLineState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_OVERHEADLINE_LIST):
    case REQUEST(ACTION_TYPES.FETCH_OVERHEADLINE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_OVERHEADLINE):
    case REQUEST(ACTION_TYPES.UPDATE_OVERHEADLINE):
    case REQUEST(ACTION_TYPES.DELETE_OVERHEADLINE):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_OVERHEADLINE_LIST):
    case FAILURE(ACTION_TYPES.FETCH_OVERHEADLINE):
    case FAILURE(ACTION_TYPES.CREATE_OVERHEADLINE):
    case FAILURE(ACTION_TYPES.UPDATE_OVERHEADLINE):
    case FAILURE(ACTION_TYPES.DELETE_OVERHEADLINE):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_OVERHEADLINE_LIST):
      return {
        ...state,
        loading: false,
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_OVERHEADLINE):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_OVERHEADLINE):
    case SUCCESS(ACTION_TYPES.UPDATE_OVERHEADLINE):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_OVERHEADLINE):
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

const apiUrl = 'api/overhead-lines';

// Actions

export const getEntities: ICrudGetAllAction<IOverheadLine> = (page, size, sort) => ({
  type: ACTION_TYPES.FETCH_OVERHEADLINE_LIST,
  payload: axios.get<IOverheadLine>(`${apiUrl}?cacheBuster=${new Date().getTime()}`)
});

export const getEntity: ICrudGetAction<IOverheadLine> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_OVERHEADLINE,
    payload: axios.get<IOverheadLine>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IOverheadLine> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_OVERHEADLINE,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IOverheadLine> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_OVERHEADLINE,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IOverheadLine> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_OVERHEADLINE,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
