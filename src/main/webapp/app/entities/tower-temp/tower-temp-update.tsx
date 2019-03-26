import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './tower-temp.reducer';
import { ITowerTemp } from 'app/shared/model/tower-temp.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ITowerTempUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface ITowerTempUpdateState {
  isNew: boolean;
}

export class TowerTempUpdate extends React.Component<ITowerTempUpdateProps, ITowerTempUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
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
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { towerTempEntity } = this.props;
      const entity = {
        ...towerTempEntity,
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
    this.props.history.push('/entity/tower-temp');
  };

  render() {
    const { towerTempEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="brazilbmteApp.towerTemp.home.createOrEditLabel">
              <Translate contentKey="brazilbmteApp.towerTemp.home.createOrEditLabel">Create or edit a TowerTemp</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : towerTempEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="tower-temp-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="towerNumberLabel" for="towerNumber">
                    <Translate contentKey="brazilbmteApp.towerTemp.towerNumber">Tower Number</Translate>
                  </Label>
                  <AvField id="tower-temp-towerNumber" type="text" name="towerNumber" />
                </AvGroup>
                <AvGroup>
                  <Label id="serialNumberLabel" for="serialNumber">
                    <Translate contentKey="brazilbmteApp.towerTemp.serialNumber">Serial Number</Translate>
                  </Label>
                  <AvField id="tower-temp-serialNumber" type="text" name="serialNumber" />
                </AvGroup>
                <AvGroup>
                  <Label id="longitudeLabel" for="longitude">
                    <Translate contentKey="brazilbmteApp.towerTemp.longitude">Longitude</Translate>
                  </Label>
                  <AvField id="tower-temp-longitude" type="text" name="longitude" />
                </AvGroup>
                <AvGroup>
                  <Label id="latitudeLabel" for="latitude">
                    <Translate contentKey="brazilbmteApp.towerTemp.latitude">Latitude</Translate>
                  </Label>
                  <AvField id="tower-temp-latitude" type="text" name="latitude" />
                </AvGroup>
                <AvGroup>
                  <Label id="altitudeLabel" for="altitude">
                    <Translate contentKey="brazilbmteApp.towerTemp.altitude">Altitude</Translate>
                  </Label>
                  <AvField id="tower-temp-altitude" type="text" name="altitude" />
                </AvGroup>
                <AvGroup>
                  <Label id="utmXLabel" for="utmX">
                    <Translate contentKey="brazilbmteApp.towerTemp.utmX">Utm X</Translate>
                  </Label>
                  <AvField id="tower-temp-utmX" type="text" name="utmX" />
                </AvGroup>
                <AvGroup>
                  <Label id="utmYLabel" for="utmY">
                    <Translate contentKey="brazilbmteApp.towerTemp.utmY">Utm Y</Translate>
                  </Label>
                  <AvField id="tower-temp-utmY" type="text" name="utmY" />
                </AvGroup>
                <AvGroup>
                  <Label id="progressiveDistanceLabel" for="progressiveDistance">
                    <Translate contentKey="brazilbmteApp.towerTemp.progressiveDistance">Progressive Distance</Translate>
                  </Label>
                  <AvField id="tower-temp-progressiveDistance" type="text" name="progressiveDistance" />
                </AvGroup>
                <AvGroup>
                  <Label id="isCornerLabel" for="isCorner">
                    <Translate contentKey="brazilbmteApp.towerTemp.isCorner">Is Corner</Translate>
                  </Label>
                  <AvField id="tower-temp-isCorner" type="text" name="isCorner" />
                </AvGroup>
                <AvGroup>
                  <Label id="cornerLabel" for="corner">
                    <Translate contentKey="brazilbmteApp.towerTemp.corner">Corner</Translate>
                  </Label>
                  <AvField id="tower-temp-corner" type="text" name="corner" />
                </AvGroup>
                <AvGroup>
                  <Label id="spanDistanceLabel" for="spanDistance">
                    <Translate contentKey="brazilbmteApp.towerTemp.spanDistance">Span Distance</Translate>
                  </Label>
                  <AvField id="tower-temp-spanDistance" type="text" name="spanDistance" />
                </AvGroup>
                <AvGroup>
                  <Label id="towerTypeLabel" for="towerType">
                    <Translate contentKey="brazilbmteApp.towerTemp.towerType">Tower Type</Translate>
                  </Label>
                  <AvField id="tower-temp-towerType" type="text" name="towerType" />
                </AvGroup>
                <AvGroup>
                  <Label id="folhaLabel" for="folha">
                    <Translate contentKey="brazilbmteApp.towerTemp.folha">Folha</Translate>
                  </Label>
                  <AvField id="tower-temp-folha" type="text" name="folha" />
                </AvGroup>
                <AvGroup>
                  <Label id="sirgas2000XLabel" for="sirgas2000X">
                    <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000X">Sirgas 2000 X</Translate>
                  </Label>
                  <AvField id="tower-temp-sirgas2000X" type="text" name="sirgas2000X" />
                </AvGroup>
                <AvGroup>
                  <Label id="sirgas2000YLabel" for="sirgas2000Y">
                    <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000Y">Sirgas 2000 Y</Translate>
                  </Label>
                  <AvField id="tower-temp-sirgas2000Y" type="text" name="sirgas2000Y" />
                </AvGroup>
                <AvGroup>
                  <Label id="sirgas2000CotaLabel" for="sirgas2000Cota">
                    <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000Cota">Sirgas 2000 Cota</Translate>
                  </Label>
                  <AvField id="tower-temp-sirgas2000Cota" type="text" name="sirgas2000Cota" />
                </AvGroup>
                <AvGroup>
                  <Label id="condutorCotaLabel" for="condutorCota">
                    <Translate contentKey="brazilbmteApp.towerTemp.condutorCota">Condutor Cota</Translate>
                  </Label>
                  <AvField id="tower-temp-condutorCota" type="text" name="condutorCota" />
                </AvGroup>
                <AvGroup>
                  <Label id="pontosTowerLabel" for="pontosTower">
                    <Translate contentKey="brazilbmteApp.towerTemp.pontosTower">Pontos Tower</Translate>
                  </Label>
                  <AvField id="tower-temp-pontosTower" type="text" name="pontosTower" />
                </AvGroup>
                <AvGroup>
                  <Label id="utmCotaLabel" for="utmCota">
                    <Translate contentKey="brazilbmteApp.towerTemp.utmCota">Utm Cota</Translate>
                  </Label>
                  <AvField id="tower-temp-utmCota" type="text" name="utmCota" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoALabel" for="infoA">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoA">Info A</Translate>
                  </Label>
                  <AvField id="tower-temp-infoA" type="text" name="infoA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoBLabel" for="infoB">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoB">Info B</Translate>
                  </Label>
                  <AvField id="tower-temp-infoB" type="text" name="infoB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoCLabel" for="infoC">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoC">Info C</Translate>
                  </Label>
                  <AvField id="tower-temp-infoC" type="text" name="infoC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDALabel" for="infoDA">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoDA">Info DA</Translate>
                  </Label>
                  <AvField id="tower-temp-infoDA" type="text" name="infoDA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDBLabel" for="infoDB">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoDB">Info DB</Translate>
                  </Label>
                  <AvField id="tower-temp-infoDB" type="text" name="infoDB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDCLabel" for="infoDC">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoDC">Info DC</Translate>
                  </Label>
                  <AvField id="tower-temp-infoDC" type="text" name="infoDC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoDDLabel" for="infoDD">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoDD">Info DD</Translate>
                  </Label>
                  <AvField id="tower-temp-infoDD" type="text" name="infoDD" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoELabel" for="infoE">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoE">Info E</Translate>
                  </Label>
                  <AvField id="tower-temp-infoE" type="text" name="infoE" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoFLabel" for="infoF">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoF">Info F</Translate>
                  </Label>
                  <AvField id="tower-temp-infoF" type="text" name="infoF" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoGLabel" for="infoG">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoG">Info G</Translate>
                  </Label>
                  <AvField id="tower-temp-infoG" type="text" name="infoG" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoHALabel" for="infoHA">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoHA">Info HA</Translate>
                  </Label>
                  <AvField id="tower-temp-infoHA" type="text" name="infoHA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoHBLabel" for="infoHB">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoHB">Info HB</Translate>
                  </Label>
                  <AvField id="tower-temp-infoHB" type="text" name="infoHB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoHCLabel" for="infoHC">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoHC">Info HC</Translate>
                  </Label>
                  <AvField id="tower-temp-infoHC" type="text" name="infoHC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIALabel" for="infoIA">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoIA">Info IA</Translate>
                  </Label>
                  <AvField id="tower-temp-infoIA" type="text" name="infoIA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIBLabel" for="infoIB">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoIB">Info IB</Translate>
                  </Label>
                  <AvField id="tower-temp-infoIB" type="text" name="infoIB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoICLabel" for="infoIC">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoIC">Info IC</Translate>
                  </Label>
                  <AvField id="tower-temp-infoIC" type="text" name="infoIC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIDLabel" for="infoID">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoID">Info ID</Translate>
                  </Label>
                  <AvField id="tower-temp-infoID" type="text" name="infoID" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoIELabel" for="infoIE">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoIE">Info IE</Translate>
                  </Label>
                  <AvField id="tower-temp-infoIE" type="text" name="infoIE" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoJLabel" for="infoJ">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoJ">Info J</Translate>
                  </Label>
                  <AvField id="tower-temp-infoJ" type="text" name="infoJ" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKALabel" for="infoKA">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoKA">Info KA</Translate>
                  </Label>
                  <AvField id="tower-temp-infoKA" type="text" name="infoKA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKBLabel" for="infoKB">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoKB">Info KB</Translate>
                  </Label>
                  <AvField id="tower-temp-infoKB" type="text" name="infoKB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKCLabel" for="infoKC">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoKC">Info KC</Translate>
                  </Label>
                  <AvField id="tower-temp-infoKC" type="text" name="infoKC" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKDLabel" for="infoKD">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoKD">Info KD</Translate>
                  </Label>
                  <AvField id="tower-temp-infoKD" type="text" name="infoKD" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKELabel" for="infoKE">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoKE">Info KE</Translate>
                  </Label>
                  <AvField id="tower-temp-infoKE" type="text" name="infoKE" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoKFLabel" for="infoKF">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoKF">Info KF</Translate>
                  </Label>
                  <AvField id="tower-temp-infoKF" type="text" name="infoKF" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoLLabel" for="infoL">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoL">Info L</Translate>
                  </Label>
                  <AvField id="tower-temp-infoL" type="text" name="infoL" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoMLabel" for="infoM">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoM">Info M</Translate>
                  </Label>
                  <AvField id="tower-temp-infoM" type="text" name="infoM" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoNLabel" for="infoN">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoN">Info N</Translate>
                  </Label>
                  <AvField id="tower-temp-infoN" type="text" name="infoN" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoOALabel" for="infoOA">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoOA">Info OA</Translate>
                  </Label>
                  <AvField id="tower-temp-infoOA" type="text" name="infoOA" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoOBLabel" for="infoOB">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoOB">Info OB</Translate>
                  </Label>
                  <AvField id="tower-temp-infoOB" type="text" name="infoOB" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoPLabel" for="infoP">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoP">Info P</Translate>
                  </Label>
                  <AvField id="tower-temp-infoP" type="text" name="infoP" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoQLabel" for="infoQ">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoQ">Info Q</Translate>
                  </Label>
                  <AvField id="tower-temp-infoQ" type="text" name="infoQ" />
                </AvGroup>
                <AvGroup>
                  <Label id="infoRLabel" for="infoR">
                    <Translate contentKey="brazilbmteApp.towerTemp.infoR">Info R</Translate>
                  </Label>
                  <AvField id="tower-temp-infoR" type="text" name="infoR" />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/tower-temp" replace color="info">
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
  towerTempEntity: storeState.towerTemp.entity,
  loading: storeState.towerTemp.loading,
  updating: storeState.towerTemp.updating,
  updateSuccess: storeState.towerTemp.updateSuccess
});

const mapDispatchToProps = {
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
)(TowerTempUpdate);
