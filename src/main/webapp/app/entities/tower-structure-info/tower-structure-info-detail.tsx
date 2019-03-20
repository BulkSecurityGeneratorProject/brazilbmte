import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './tower-structure-info.reducer';
import { ITowerStructureInfo } from 'app/shared/model/tower-structure-info.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITowerStructureInfoDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class TowerStructureInfoDetail extends React.Component<ITowerStructureInfoDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { towerStructureInfoEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="brazilbmteApp.towerStructureInfo.detail.title">TowerStructureInfo</Translate> [<b>
              {towerStructureInfoEntity.id}
            </b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="folha">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.folha">Folha</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.folha}</dd>
            <dt>
              <span id="sirgas2000X">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000X">Sirgas 2000 X</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.sirgas2000X}</dd>
            <dt>
              <span id="sirgas2000Y">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000Y">Sirgas 2000 Y</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.sirgas2000Y}</dd>
            <dt>
              <span id="sirgas2000Cota">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000Cota">Sirgas 2000 Cota</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.sirgas2000Cota}</dd>
            <dt>
              <span id="condutorCota">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.condutorCota">Condutor Cota</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.condutorCota}</dd>
            <dt>
              <span id="pontosTower">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.pontosTower">Pontos Tower</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.pontosTower}</dd>
            <dt>
              <span id="utmCota">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.utmCota">Utm Cota</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.utmCota}</dd>
            <dt>
              <span id="infoA">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoA">Info A</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoA}</dd>
            <dt>
              <span id="infoB">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoB">Info B</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoB}</dd>
            <dt>
              <span id="infoC">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoC">Info C</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoC}</dd>
            <dt>
              <span id="infoDA">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDA">Info DA</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoDA}</dd>
            <dt>
              <span id="infoDB">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDB">Info DB</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoDB}</dd>
            <dt>
              <span id="infoDC">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDC">Info DC</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoDC}</dd>
            <dt>
              <span id="infoDD">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDD">Info DD</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoDD}</dd>
            <dt>
              <span id="infoE">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoE">Info E</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoE}</dd>
            <dt>
              <span id="infoF">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoF">Info F</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoF}</dd>
            <dt>
              <span id="infoG">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoG">Info G</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoG}</dd>
            <dt>
              <span id="infoHA">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHA">Info HA</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoHA}</dd>
            <dt>
              <span id="infoHB">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHB">Info HB</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoHB}</dd>
            <dt>
              <span id="infoHC">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHC">Info HC</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoHC}</dd>
            <dt>
              <span id="infoIA">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIA">Info IA</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoIA}</dd>
            <dt>
              <span id="infoIB">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIB">Info IB</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoIB}</dd>
            <dt>
              <span id="infoIC">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIC">Info IC</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoIC}</dd>
            <dt>
              <span id="infoID">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoID">Info ID</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoID}</dd>
            <dt>
              <span id="infoIE">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIE">Info IE</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoIE}</dd>
            <dt>
              <span id="infoJ">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoJ">Info J</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoJ}</dd>
            <dt>
              <span id="infoKA">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKA">Info KA</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoKA}</dd>
            <dt>
              <span id="infoKB">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKB">Info KB</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoKB}</dd>
            <dt>
              <span id="infoKC">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKC">Info KC</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoKC}</dd>
            <dt>
              <span id="infoKD">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKD">Info KD</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoKD}</dd>
            <dt>
              <span id="infoKE">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKE">Info KE</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoKE}</dd>
            <dt>
              <span id="infoKF">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKF">Info KF</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoKF}</dd>
            <dt>
              <span id="infoL">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoL">Info L</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoL}</dd>
            <dt>
              <span id="infoM">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoM">Info M</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoM}</dd>
            <dt>
              <span id="infoN">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoN">Info N</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoN}</dd>
            <dt>
              <span id="infoOA">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoOA">Info OA</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoOA}</dd>
            <dt>
              <span id="infoOB">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoOB">Info OB</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoOB}</dd>
            <dt>
              <span id="infoP">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoP">Info P</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoP}</dd>
            <dt>
              <span id="infoQ">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoQ">Info Q</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoQ}</dd>
            <dt>
              <span id="infoR">
                <Translate contentKey="brazilbmteApp.towerStructureInfo.infoR">Info R</Translate>
              </span>
            </dt>
            <dd>{towerStructureInfoEntity.infoR}</dd>
          </dl>
          <Button tag={Link} to="/entity/tower-structure-info" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/tower-structure-info/${towerStructureInfoEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ towerStructureInfo }: IRootState) => ({
  towerStructureInfoEntity: towerStructureInfo.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TowerStructureInfoDetail);
