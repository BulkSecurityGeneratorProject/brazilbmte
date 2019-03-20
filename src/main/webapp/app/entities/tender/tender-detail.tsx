import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './tender.reducer';
import { ITender } from 'app/shared/model/tender.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITenderDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class TenderDetail extends React.Component<ITenderDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { tenderEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="brazilbmteApp.tender.detail.title">Tender</Translate> [<b>{tenderEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="tenderName">
                <Translate contentKey="brazilbmteApp.tender.tenderName">Tender Name</Translate>
              </span>
            </dt>
            <dd>{tenderEntity.tenderName}</dd>
            <dt>
              <span id="tenderLength">
                <Translate contentKey="brazilbmteApp.tender.tenderLength">Tender Length</Translate>
              </span>
            </dt>
            <dd>{tenderEntity.tenderLength}</dd>
            <dt>
              <span id="towerCount">
                <Translate contentKey="brazilbmteApp.tender.towerCount">Tower Count</Translate>
              </span>
            </dt>
            <dd>{tenderEntity.towerCount}</dd>
            <dt>
              <Translate contentKey="brazilbmteApp.tender.geometryJson">Geometry Json</Translate>
            </dt>
            <dd>{tenderEntity.geometryJson ? tenderEntity.geometryJson.id : ''}</dd>
            <dt>
              <Translate contentKey="brazilbmteApp.tender.project">Project</Translate>
            </dt>
            <dd>{tenderEntity.project ? tenderEntity.project.id : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/tender" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/tender/${tenderEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ tender }: IRootState) => ({
  tenderEntity: tender.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TenderDetail);
