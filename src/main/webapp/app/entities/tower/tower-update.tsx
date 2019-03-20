import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { ITowerStructureInfo } from 'app/shared/model/tower-structure-info.model';
import { getEntities as getTowerStructureInfos } from 'app/entities/tower-structure-info/tower-structure-info.reducer';
import { IGeometry } from 'app/shared/model/geometry.model';
import { getEntities as getGeometries } from 'app/entities/geometry/geometry.reducer';
import { ITender } from 'app/shared/model/tender.model';
import { getEntities as getTenders } from 'app/entities/tender/tender.reducer';
import { getEntity, updateEntity, createEntity, reset } from './tower.reducer';
import { ITower } from 'app/shared/model/tower.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ITowerUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ITowerUpdateState {
  isNew: boolean;
  towerStructureInfoId: string;
  geometryJsonId: string;
  tenderId: string;
}

export class TowerUpdate extends React.Component<ITowerUpdateProps, ITowerUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      towerStructureInfoId: '0',
      geometryJsonId: '0',
      tenderId: '0',
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }

    this.props.getTowerStructureInfos();
    this.props.getGeometries();
    this.props.getTenders();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { towerEntity } = this.props;
      const entity = {
        ...towerEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/tower');
  };

  render() {
    const { towerEntity, towerStructureInfos, geometries, tenders, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="brazilbmteApp.tower.home.createOrEditLabel">
              <Translate contentKey="brazilbmteApp.tower.home.createOrEditLabel">Create or edit a Tower</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : towerEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="tower-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="towerNumberLabel" for="towerNumber">
                    <Translate contentKey="brazilbmteApp.tower.towerNumber">Tower Number</Translate>
                  </Label>
                  <AvField id="tower-towerNumber" type="text" name="towerNumber" />
                </AvGroup>
                <AvGroup>
                  <Label id="serialNumberLabel" for="serialNumber">
                    <Translate contentKey="brazilbmteApp.tower.serialNumber">Serial Number</Translate>
                  </Label>
                  <AvField id="tower-serialNumber" type="string" className="form-control" name="serialNumber" />
                </AvGroup>
                <AvGroup>
                  <Label id="longitudeLabel" for="longitude">
                    <Translate contentKey="brazilbmteApp.tower.longitude">Longitude</Translate>
                  </Label>
                  <AvField id="tower-longitude" type="string" className="form-control" name="longitude" />
                </AvGroup>
                <AvGroup>
                  <Label id="latitudeLabel" for="latitude">
                    <Translate contentKey="brazilbmteApp.tower.latitude">Latitude</Translate>
                  </Label>
                  <AvField id="tower-latitude" type="string" className="form-control" name="latitude" />
                </AvGroup>
                <AvGroup>
                  <Label id="altitudeLabel" for="altitude">
                    <Translate contentKey="brazilbmteApp.tower.altitude">Altitude</Translate>
                  </Label>
                  <AvField id="tower-altitude" type="string" className="form-control" name="altitude" />
                </AvGroup>
                <AvGroup>
                  <Label id="utmXLabel" for="utmX">
                    <Translate contentKey="brazilbmteApp.tower.utmX">Utm X</Translate>
                  </Label>
                  <AvField id="tower-utmX" type="string" className="form-control" name="utmX" />
                </AvGroup>
                <AvGroup>
                  <Label id="utmYLabel" for="utmY">
                    <Translate contentKey="brazilbmteApp.tower.utmY">Utm Y</Translate>
                  </Label>
                  <AvField id="tower-utmY" type="string" className="form-control" name="utmY" />
                </AvGroup>
                <AvGroup>
                  <Label id="progressiveDistanceLabel" for="progressiveDistance">
                    <Translate contentKey="brazilbmteApp.tower.progressiveDistance">Progressive Distance</Translate>
                  </Label>
                  <AvField id="tower-progressiveDistance" type="string" className="form-control" name="progressiveDistance" />
                </AvGroup>
                <AvGroup>
                  <Label id="isCornerLabel" check>
                    <AvInput id="tower-isCorner" type="checkbox" className="form-control" name="isCorner" />
                    <Translate contentKey="brazilbmteApp.tower.isCorner">Is Corner</Translate>
                  </Label>
                </AvGroup>
                <AvGroup>
                  <Label id="cornerLabel" for="corner">
                    <Translate contentKey="brazilbmteApp.tower.corner">Corner</Translate>
                  </Label>
                  <AvField id="tower-corner" type="string" className="form-control" name="corner" />
                </AvGroup>
                <AvGroup>
                  <Label id="spanDistanceLabel" for="spanDistance">
                    <Translate contentKey="brazilbmteApp.tower.spanDistance">Span Distance</Translate>
                  </Label>
                  <AvField id="tower-spanDistance" type="string" className="form-control" name="spanDistance" />
                </AvGroup>
                <AvGroup>
                  <Label id="towerTypeLabel" for="towerType">
                    <Translate contentKey="brazilbmteApp.tower.towerType">Tower Type</Translate>
                  </Label>
                  <AvField id="tower-towerType" type="text" name="towerType" />
                </AvGroup>
                <AvGroup>
                  <Label for="towerStructureInfo.id">
                    <Translate contentKey="brazilbmteApp.tower.towerStructureInfo">Tower Structure Info</Translate>
                  </Label>
                  <AvInput id="tower-towerStructureInfo" type="select" className="form-control" name="towerStructureInfo.id">
                    <option value="" key="0" />
                    {towerStructureInfos
                      ? towerStructureInfos.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label for="geometryJson.id">
                    <Translate contentKey="brazilbmteApp.tower.geometryJson">Geometry Json</Translate>
                  </Label>
                  <AvInput id="tower-geometryJson" type="select" className="form-control" name="geometryJson.id">
                    <option value="" key="0" />
                    {geometries
                      ? geometries.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label for="tender.id">
                    <Translate contentKey="brazilbmteApp.tower.tender">Tender</Translate>
                  </Label>
                  <AvInput id="tower-tender" type="select" className="form-control" name="tender.id">
                    <option value="" key="0" />
                    {tenders
                      ? tenders.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/tower" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />&nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />&nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  towerStructureInfos: storeState.towerStructureInfo.entities,
  geometries: storeState.geometry.entities,
  tenders: storeState.tender.entities,
  towerEntity: storeState.tower.entity,
  loading: storeState.tower.loading,
  updating: storeState.tower.updating,
  updateSuccess: storeState.tower.updateSuccess
});

const mapDispatchToProps = {
  getTowerStructureInfos,
  getGeometries,
  getTenders,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TowerUpdate);
